package ru.otus.spring01.domain;

import java.util.ArrayList;

public class Question {

    private String question;
    private ArrayList answers;
    private int correctAnswer;

    public Question(String question, ArrayList answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList getAnswers() {
        return answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
