package ru.otus.spring01.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TestReport {
    private final Student student;
    private final int numberOfQuestions;
    private final int numberOfPositiveAnswers;
}
