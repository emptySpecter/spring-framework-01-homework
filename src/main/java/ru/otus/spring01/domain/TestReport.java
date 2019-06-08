package ru.otus.spring01.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class TestReport {

    private Student student;

    private int numberOfQuestions;
    private int numberOfPositiveAnswers;
}
