package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.Test;
import ru.otus.spring01.domain.TestReport;

import java.util.List;
import java.util.Locale;

@Service
public class TestingServiceImpl implements TestingService {
    private CommunicationService console;
    private MessageSource messageSource;
    private String[] strings;
    private Locale locale;

    public TestingServiceImpl(CommunicationService console, MessageSource messageSource, @Value("${locale.language:}") String language, @Value("${locale.country:}") String country) {
        this.console = console;
        this.messageSource = messageSource;
        locale = new Locale(language, country);

    }

    @Override
    public TestReport testing(Student student, Test test) {
        List<Question> questions = test.getQuestions();
        int numberOfQuestions = questions.size();
        int numberOfPositiveAnswers = 0;

        for (Question question : questions) {
            console.writeLine("");
            console.writeLine(question.getQuestion());
            int questionNo = 1;
            for (String answer : question.getAnswers()) {
                console.writeLine(String.format("%d. %s \n", questionNo++, answer));
            }
            while (true) {
                console.writeLine(messageSource.getMessage("testing.prompt", strings, locale));
                String answ = console.readLine();
                if (answ.matches("\\d")) {
                    int no = Integer.valueOf(answ);
                    if (0 < no && no < questionNo) {
                        if (no == question.getCorrectAnswer()) numberOfPositiveAnswers++;
                        break;
                    }
                }
            }
        }
        console.writeLine("");

        return new TestReport(student, numberOfQuestions, numberOfPositiveAnswers);
    }

    @Override
    public void printReport(TestReport report) {
        console.writeLine("");
        console.writeLine("-------------------------------------------------------------------------------------");
        console.writeLine(messageSource.getMessage("report.line1", strings, locale));
        console.writeLine(messageSource.getMessage("report.line2", strings, locale) + "  " + report.getStudent().getFirstName() + " " + report.getStudent().getLastName());
        strings = new String[]{String.valueOf(report.getNumberOfPositiveAnswers()), String.valueOf(report.getNumberOfQuestions())};
        console.writeLine(messageSource.getMessage("report.line3", strings, locale));
        console.writeLine("");
        console.writeLine("-------------------------------------------------------------------------------------");
    }
}
