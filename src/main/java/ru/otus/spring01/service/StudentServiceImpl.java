package ru.otus.spring01.service;

import ru.otus.spring01.domain.Student;

import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentServiceImpl implements StudentService {


    public StudentServiceImpl() { }

    private static final String ruNameRegEx = "[А-ЯЁ][-А-яЁё]+";
    private Pattern ruNamePattern = Pattern.compile(ruNameRegEx);

    @Override
    public Student newStudent() {
        Scanner scanner = new Scanner(System.in);
        String firstName, lastName;
        while(true) {
            System.out.println("Введите ваше имя и нажмите клавишу Enter:");
            firstName = scanner.nextLine();
            if(ruNamePattern.matcher(firstName).matches()) break;
            System.out.println("Имя - одно (допускается дефис) слово в русском алфавите с заглавной буквы!");
        }
        while(true) {
            System.out.println("Введите вашу фамилию и нажмите клавишу Enter:");
            lastName = scanner.nextLine();
            if(ruNamePattern.matcher(firstName).matches()) break;
            System.out.println("Фамилия - одно (допускается дефис) слово в русском алфавите с заглавной буквы!");
        }

        System.out.println();
        System.out.println("Введено имя: " + firstName + ", фамилия: " + lastName);
        System.out.println();

        return new Student(firstName, lastName);
    }

}
