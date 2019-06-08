package ru.otus.spring01.service;

import ru.otus.spring01.domain.Student;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentServiceImpl implements StudentService {

    private ConsoleService console;

    public StudentServiceImpl(ConsoleService console) {
        this.console = console;
    }

    private Pattern ruNamePattern = Pattern.compile("[А-ЯЁ][-А-яЁё]+");

    @Override
    public Student newStudent() {
        String firstName, lastName;
        while (true) {
            console.writeLine("Введите ваше имя и нажмите клавишу Enter:");
            firstName = console.readLine();
            if (ruNamePattern.matcher(firstName).matches()) break;
            console.writeLine("Имя - одно слово в русском алфавите (допускается дефис) с заглавной буквы!");
        }
        while (true) {
            console.writeLine("Введите вашу фамилию и нажмите клавишу Enter:");
            lastName = console.readLine();
            if (ruNamePattern.matcher(firstName).matches()) break;
            console.writeLine("Фамилия - одно слово в русском алфавите (допускается дефис) с заглавной буквы!");
        }

        console.writeLine("");
        console.writeLine("Введено имя: " + firstName + ", фамилия: " + lastName);
        console.writeLine("");

        return new Student(firstName, lastName);
    }

}
