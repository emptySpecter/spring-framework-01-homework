package ru.otus.spring01.dao;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Test;
import ru.otus.spring01.service.LocalFileNameService;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service
@Getter
public class TestDaoCSV implements TestDao {

    private final Test test;

    public TestDaoCSV(LocalFileNameService fileNameService) {
        URI uri = fileNameService.get();
        Scanner scanner = null;
        try {
            scanner = new Scanner(Paths.get(uri));
        } catch (IOException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
        List<Question> questions = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] terms = scanner.nextLine().split(";");
            int len = terms.length;
            if (len >= 3) {
                try {
                    int indexOfPostiveAnswer = Integer.valueOf(terms[len - 1]);
                    questions.add(new Question(terms[0], new ArrayList<>(Arrays.asList(Arrays.copyOfRange(terms, 1, len - 1))), indexOfPostiveAnswer));
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect question " + terms[0]);
                }
            }
        }
        test = new Test(questions);
    }
}
