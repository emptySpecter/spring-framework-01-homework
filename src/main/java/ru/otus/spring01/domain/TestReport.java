package ru.otus.spring01.domain;

public class TestReport {

    private Student student;

    private int numberOfQuestions;
    private int numberOfPositiveAnswers;

    public TestReport(Student student, int numberOfQuestions, int numberOfPositiveAnswers) {
        this.student = student;
        this.numberOfQuestions = numberOfQuestions;
        this.numberOfPositiveAnswers = numberOfPositiveAnswers;
    }

    public Student getStudent() {
        return student;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public int getNumberOfPositiveAnswers() {
        return numberOfPositiveAnswers;
    }

}
