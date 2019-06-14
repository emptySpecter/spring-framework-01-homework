package ru.otus.spring01.service;

import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.Student;

import java.util.Locale;
import java.util.regex.Pattern;

@Service
public class StudentServiceImpl implements StudentService {

    private CommunicationService console;
    private MessageSource messageSource;

    public StudentServiceImpl(CommunicationService console, MessageSource messageSource) {
        this.console = console;
        this.messageSource = messageSource;
    }

    private Pattern ruNamePattern = Pattern.compile("[А-ЯЁ][-А-яЁё]+");

    @Override
    public Student newStudent() {
        String firstName, lastName;
        while (true) {
            console.writeLine(messageSource.getMessage("enter.firstname", new String[]{},Locale.ENGLISH));
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
