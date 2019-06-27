package ru.otus.spring01.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CommunicationServiceImpl implements CommunicationService {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void writeLine(String string) {
        System.out.println(string);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
