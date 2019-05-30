package ru.otus.spring01.dao;

import ru.otus.spring01.domain.Test;

import java.io.InputStream;
import java.util.Scanner;

public class TestDaoSimple implements TestDao {


    public TestDaoSimple(String path) {
        InputStream stream = TestDaoSimple.class.getResourceAsStream(path);
        Scanner scanner = new Scanner(stream);
        System.out.println(scanner.nextLine());
    }

    public Test getTest() {
        return null;
    }
}
