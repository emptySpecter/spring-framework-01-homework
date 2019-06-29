package ru.otus.spring01.service;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public class CommunicationServiceImpl implements CommunicationService {
    private final Scanner scanner;
    private InputStream in;
    private PrintStream out;

    public CommunicationServiceImpl(InProxy inProxy, OutProxy outProxy) {
        in = inProxy.getIn();
        out = outProxy.getOut();
        scanner = new Scanner(in, String.valueOf(StandardCharsets.UTF_8));
    }

    @Override
    public void writeLine(String string) {
        out.println(string);
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
