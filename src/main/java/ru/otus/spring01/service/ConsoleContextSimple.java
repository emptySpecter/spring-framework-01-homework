package ru.otus.spring01.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Component
@Profile("!shell")
public class ConsoleContextSimple extends ConsoleContext {
    public ConsoleContextSimple() {
        out = System.out;
        in = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));
    }
}

