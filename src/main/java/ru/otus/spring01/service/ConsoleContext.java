package ru.otus.spring01.service;

import java.io.PrintStream;
import java.util.Scanner;

public interface ConsoleContext {
    void setOut(PrintStream printStream);
    PrintStream getOut();
    void setIn(Scanner scanner);
    Scanner getIn();
}
