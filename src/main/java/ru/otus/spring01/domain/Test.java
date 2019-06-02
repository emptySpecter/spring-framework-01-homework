package ru.otus.spring01.domain;

import java.util.List;

public class Test {

    private List<Question> questions;

    public Test(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
