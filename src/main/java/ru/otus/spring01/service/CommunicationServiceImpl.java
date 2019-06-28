package ru.otus.spring01.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public class CommunicationServiceImpl implements CommunicationService {
    private final Scanner scanner;
    public CommunicationServiceImpl(InputStream in, OutputStream out) {
        scanner =  new Scanner(in, String.valueOf(StandardCharsets.UTF_8));

    }

    @Override
    public void writeLine(String string) {
        System.out.println(string);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
