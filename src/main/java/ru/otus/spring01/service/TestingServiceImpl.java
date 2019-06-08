package ru.otus.spring01.service;

import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.Test;
import ru.otus.spring01.domain.TestReport;

import java.util.List;
import java.util.Scanner;

public class TestingServiceImpl implements TestingService {
    private ConsoleService console;

    public TestingServiceImpl(ConsoleService console) {
        this.console = console;
    }

    @Override
    public TestReport Testing(Student student, Test test) {
        List<Question> questions = test.getQuestions();
        int numberOfQuestions = questions.size();
        int numberOfPositiveAnswers = 0;

        for (Question question : questions) {
           console.writeLine("");
           console.writeLine(question.getQuestion());
            int questionNo = 1;
            for (String answer : question.getAnswers()) {
                console.writeLine(String.format("%d. %s \n",  questionNo++, answer));
            }
            while (true) {
               console.writeLine("Введите номер (одну цифру) предлагаемого вами ответа: ");
                String answ = console.readLine();
                if (answ.matches("\\d")) {
                    int no = Integer.valueOf(answ);
                    if (0 < no && no < questionNo) {
                        if (no == question.getCorrectAnswer()) numberOfPositiveAnswers++;
                        break;
                    }
                }
            }
        }
       console.writeLine("");

        return new TestReport(student, numberOfQuestions, numberOfPositiveAnswers);
    }

    @Override
    public void printReport(TestReport report) {
       console.writeLine("");
       console.writeLine("-------------------------------------------------------------------------------------");
       console.writeLine("Результаты тестирования");
       console.writeLine("студент:  " + report.getStudent().getFirstName() + " " + report.getStudent().getLastName());
       console.writeLine(String.format("%d правильных ответов из %d .", report.getNumberOfPositiveAnswers(), report.getNumberOfQuestions()));
       console.writeLine("");
       console.writeLine("-------------------------------------------------------------------------------------");
    }
}
