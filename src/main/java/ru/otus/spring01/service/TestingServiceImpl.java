package ru.otus.spring01.service;

import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.Test;
import ru.otus.spring01.domain.TestReport;

import java.util.List;

@Service
public class TestingServiceImpl implements TestingService {

    private static final String TESTING_PROMPT = "testing.prompt";
    private static final String REPORT_LINE_1 = "report.line1";
    private static final String REPORT_LINE_2 = "report.line2";
    private static final String REPORT_LINE_3 = "report.line3";

    private CommunicationService console;
    private MessageLocalizationService localizationService;


    public TestingServiceImpl(CommunicationService console, MessageLocalizationService localizationService) {
        this.console = console;
        this.localizationService = localizationService;

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
                console.writeLine(localizationService.getLocalMessage(TESTING_PROMPT));
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
        console.writeLine(localizationService.getLocalMessage(REPORT_LINE_1));
        console.writeLine(localizationService.getLocalMessage(REPORT_LINE_2) + "  " + report.getStudent().getFirstName() + " " + report.getStudent().getLastName());
        console.writeLine(localizationService.getLocalMessageParams(REPORT_LINE_3, new String[]{String.valueOf(report.getNumberOfPositiveAnswers()), String.valueOf(report.getNumberOfQuestions())}));
        console.writeLine("");
        console.writeLine("-------------------------------------------------------------------------------------");
    }
}
