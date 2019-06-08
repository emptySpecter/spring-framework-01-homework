package ru.otus.spring01.service;

import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void writeLine(String string) {
        System.out.println(string);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
