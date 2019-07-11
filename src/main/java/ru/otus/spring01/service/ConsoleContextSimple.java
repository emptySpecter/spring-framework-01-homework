package ru.otus.spring01.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Component
@ConditionalOnProperty(prefix = "spring.shell.interactive", name = "enabled", havingValue = "false")
public class ConsoleContextSimple extends ConsoleContext {
    public ConsoleContextSimple() {
        out = System.out;
        in = new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8));
    }
}

