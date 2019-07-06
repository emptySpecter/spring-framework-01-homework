package ru.otus.spring01.service;

import org.jline.terminal.Terminal;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

@Component
@ConditionalOnProperty(prefix = "spring.shell.interactive", name = "enabled", havingValue = "true")
public class ConsoleContextTerminal extends ConsoleContext {

    public ConsoleContextTerminal(Terminal terminal) throws UnsupportedEncodingException {
        in = new Scanner(terminal.input(), "UTF-8");
        out = new PrintStream(terminal.output(), true, "UTF-8");
    }

}
