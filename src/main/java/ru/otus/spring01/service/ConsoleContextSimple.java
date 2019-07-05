package ru.otus.spring01.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.PrintStream;
import java.util.Scanner;

@AllArgsConstructor
@Data
public class ConsoleContextSimple implements ConsoleContext{
    private PrintStream out;
    private Scanner in;
}

