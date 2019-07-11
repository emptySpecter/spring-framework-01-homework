package ru.otus.spring01.service;

import lombok.Getter;

import java.io.PrintStream;
import java.util.Scanner;


@Getter
public class ConsoleContext {
    protected PrintStream out;
    protected Scanner in;

}
