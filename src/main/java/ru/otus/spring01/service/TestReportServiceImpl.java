package ru.otus.spring01.service;

import ru.otus.spring01.domain.TestReport;

public class TestReportServiceImpl implements TestReportService {
    @Override
    public void printReport(TestReport report) {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Результаты тестирования");
        System.out.println("Студент:  " + report.getStudent().getFirstName() + " " + report.getStudent().getLastName());
        System.out.printf("%d правильных ответов из %d вопросов", report.getNumberOfPositiveAnswers(), report.getNumberOfQuestions());
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------------");
    }
}
