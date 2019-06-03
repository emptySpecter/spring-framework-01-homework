package ru.otus.spring01.service;

import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.Test;
import ru.otus.spring01.domain.TestReport;

import java.util.List;
import java.util.Scanner;

public class TestingServiceImpl implements TestingService {

    @Override
    public TestReport Testing(Student student, Test test) {
        Scanner scanner = new Scanner(System.in);
        List<Question> questions = test.getQuestions();
        int numberOfQuestions = questions.size();
        int numberOfPositiveAnswers = 0;

        for (Question question : questions) {
            System.out.println();
            System.out.println(question.getQuestion());
            int questionNo = 1;
            for (String answer : question.getAnswers()) {
                System.out.printf("%d. %s \n", questionNo++, answer);
            }
            while (true) {
                System.out.println("Введите номер (одну цифру) предлагаемого вами ответа: ");
                String answ = scanner.next();
                if (answ.matches("\\d")) {
                    int no = Integer.valueOf(answ);
                    if (0 < no && no < questionNo) {
                        if (no == question.getCorrectAnswer()) numberOfPositiveAnswers++;
                        break;
                    }
                }
            }
        }
        System.out.println();

        return new TestReport(student, numberOfQuestions, numberOfPositiveAnswers);
    }

    @Override
    public void printReport(TestReport report) {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Результаты тестирования");
        System.out.println("студент:  " + report.getStudent().getFirstName() + " " + report.getStudent().getLastName());
        System.out.printf("%d правильных ответов из %d .", report.getNumberOfPositiveAnswers(), report.getNumberOfQuestions());
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
    }
}
