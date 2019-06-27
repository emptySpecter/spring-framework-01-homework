package ru.otus.spring01.service;

import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.Student;

import java.util.regex.Pattern;

@Service
public class StudentServiceImpl implements StudentService {

    private static final String NAME_VALIDATION = "name.validation";
    private static final String FIRSTNAME_ENTER = "firstname.enter";
    private static final String FIRSTNAME_ADVICE = "firstname.advice";
    private static final String LASTNAME_ENTER = "lastname.enter";
    private static final String LASTNAME_ADVICE = "lastname.advice";
    private static final String CONFIRMATION = "confirmation";

    private final CommunicationService console;
    private final MessageLocalizationService localizationService;
    private Pattern namePattern;

    public StudentServiceImpl(CommunicationService console, MessageLocalizationService localizationService) {
        this.console = console;
        this.localizationService = localizationService;
    }


    @Override
    public Student newStudent() {
        String firstName, lastName;
        if (namePattern == null) {
            namePattern = Pattern.compile(localizationService.getLocalMessage(NAME_VALIDATION));
        }
        while (true) {
            console.writeLine(localizationService.getLocalMessage(FIRSTNAME_ENTER));
            firstName = console.readLine();
            if (namePattern.matcher(firstName).matches()) break;
            console.writeLine(localizationService.getLocalMessage(FIRSTNAME_ADVICE));
        }
        while (true) {
            console.writeLine(localizationService.getLocalMessage(LASTNAME_ENTER));
            lastName = console.readLine();
            if (namePattern.matcher(lastName).matches()) break;
            console.writeLine(localizationService.getLocalMessage(LASTNAME_ADVICE));
        }

        console.writeLine("");
        console.writeLine(localizationService.getLocalMessageParams(CONFIRMATION, new String[]{firstName, lastName}));
        console.writeLine("");

        return new Student(firstName, lastName);
    }

}
