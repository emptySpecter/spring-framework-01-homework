package ru.otus.spring01.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Question {

    private final String question;
    private final List<String> answers;
    private final int correctAnswer;

    public Question(String question, List<String> answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
}
