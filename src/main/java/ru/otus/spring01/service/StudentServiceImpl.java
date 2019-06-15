package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.Student;

import java.util.Locale;
import java.util.regex.Pattern;

@Service
public class StudentServiceImpl implements StudentService {

    private CommunicationService console;
    private MessageSource messageSource;
    private String language;
    private String country;

    private Pattern namePattern;

    public StudentServiceImpl(CommunicationService console, MessageSource messageSource, @Value("${locale.language:}") String language, @Value("${locale.country:}") String country) {
        this.console = console;
        this.messageSource = messageSource;
        this.language = language;
        this.country = country;
    }


    @Override
    public Student newStudent() {
        String firstName, lastName;
        String[] strings = {};
        Locale locale = new Locale(language, country);
        if (namePattern == null) {
            namePattern = Pattern.compile(messageSource.getMessage("name.validation", strings, locale));
        }
        while (true) {
            console.writeLine(messageSource.getMessage("firstname.enter", strings, locale));
            firstName = console.readLine();
            if (namePattern.matcher(firstName).matches()) break;
            console.writeLine(messageSource.getMessage("firstname.advice", strings, locale));
        }
        while (true) {
            console.writeLine(messageSource.getMessage("lastname.enter", strings, locale));
            lastName = console.readLine();
            if (namePattern.matcher(lastName).matches()) break;
            console.writeLine(messageSource.getMessage("lastname.advice", strings, locale));
        }

        strings = new String[]{firstName, lastName};
        console.writeLine("");
        console.writeLine(messageSource.getMessage("confirmation", strings, locale));
        console.writeLine("");

        return new Student(firstName, lastName);
    }

}
