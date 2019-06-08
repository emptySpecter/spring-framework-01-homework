package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestDaoCSV implements TestDao {

    private Test test;

    public TestDaoCSV(String path) {
        InputStream stream = TestDaoCSV.class.getResourceAsStream(path);
        Scanner scanner = new Scanner(stream);
        List<Question> questions = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] terms = scanner.nextLine().split(";");
            int len = terms.length;
            if(len >= 3) {
                try {
                    int indexOfPostiveAnswer = Integer.valueOf(terms[len - 1]);
                    questions.add(new Question(terms[0], new ArrayList<>(Arrays.asList(Arrays.copyOfRange(terms, 1, len - 1))), indexOfPostiveAnswer));
                }catch (NumberFormatException e){

                }
              }
        }
        test = new Test(questions);
    }

    public Test getTest() {
        return test;
    }
}
