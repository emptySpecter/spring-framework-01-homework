package ru.otus.spring01.domain;

import java.util.List;

public class Question {

    private String question;
    private List<String> answers;
    private int correctAnswer;

    public Question(String question, List<String> answers, int correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answers=" + answers +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
