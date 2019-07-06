package ru.otus.spring01.test.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring01.service.CommunicationServiceImpl;
import ru.otus.spring01.service.ConsoleContextSimple;
import ru.otus.spring01.service.MessageLocalizationServiceImpl;
import ru.otus.spring01.service.StudentServiceImpl;
import ru.otus.spring01.settings.AppProps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@DisplayName("StudentServiceImpl должен корректно")
@SpringBootTest
public class StudentServiceImplTest {

    private static final String EOL = System.getProperty("line.separator");
    private static final String FIRSTNAME_ADVICE = "firstname.advice";
    private static final String LASTNAME_ADVICE = "lastname.advice";
    private static final String CONFIRMATION = "confirmation";
    private static Locale locale;
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @Autowired
    private CommunicationServiceImpl communicationService;
    @Autowired
    private AppProps appProps;
    @Autowired
    private MessageLocalizationServiceImpl messageLocalizationService;
    @MockBean
    private ConsoleContextSimple consoleContext;

    private static Scanner prepareInput(String inString) {
        return new Scanner(new ByteArrayInputStream(inString.getBytes(StandardCharsets.UTF_8)));
    }

    //prepare data for newStudentValidationOfConversationTest
    private static Stream<Arguments> stringIntAndListProvider() {
        if (locale.equals(new Locale("ru", "RU"))) {
            return Stream.of(
                    arguments(1, 3, CONFIRMATION, Arrays.asList("Данила", "Черёмухин")),
                    arguments(2, 1, FIRSTNAME_ADVICE, Arrays.asList("Данила Черёмухин", "Данила", "Черёмухин")),
                    arguments(3, 1, FIRSTNAME_ADVICE, Arrays.asList("Danila", "Данила", "Черёмухин")),
                    arguments(4, 1, FIRSTNAME_ADVICE, Arrays.asList("Данила1", "Данила", "Черёмухин")),
                    arguments(5, 1, FIRSTNAME_ADVICE, Arrays.asList("Данила,", "Данила", "Черёмухин")),
                    arguments(6, 2, LASTNAME_ADVICE, Arrays.asList("Данила", "Данила Черёмухин", "Черёмухин")),
                    arguments(7, 2, LASTNAME_ADVICE, Arrays.asList("Данила", "Cheremukhin", "Черёмухин")),
                    arguments(8, 2, LASTNAME_ADVICE, Arrays.asList("Данила", "Черёмухин123", "Черёмухин")),
                    arguments(9, 2, LASTNAME_ADVICE, Arrays.asList("Данила", "Черёмухин,", "Черёмухин"))
            );
        } else {
            return Stream.of(
                    arguments(1, 3, CONFIRMATION, Arrays.asList("Danila", "Cheremukhin")),
                    arguments(2, 1, FIRSTNAME_ADVICE, Arrays.asList("Danila Cheremukhin", "Danila", "Cheremukhin")),
                    arguments(3, 1, FIRSTNAME_ADVICE, Arrays.asList("Данила", "Danila", "Cheremukhin")),
                    arguments(4, 1, FIRSTNAME_ADVICE, Arrays.asList("Danila1", "Cheremukhin", "Cheremukhin")),
                    arguments(5, 1, FIRSTNAME_ADVICE, Arrays.asList("Danila,", "Cheremukhin", "Cheremukhin")),
                    arguments(6, 2, LASTNAME_ADVICE, Arrays.asList("Danila", "Danila Cheremukhin", "Cheremukhin")),
                    arguments(7, 2, LASTNAME_ADVICE, Arrays.asList("Danila", "Черёмухин", "Cheremukhin")),
                    arguments(8, 2, LASTNAME_ADVICE, Arrays.asList("Danila", "Cheremukhin123", "Cheremukhin")),
                    arguments(9, 2, LASTNAME_ADVICE, Arrays.asList("Danila", "Cheremukhin,", "Cheremukhin"))
            );
        }
    }

    @BeforeEach
    public void testSettings() {
        locale = appProps.getJavaLocale();
    }

    @DisplayName("принимать и выводить имя и фамилию пользователя")
    @Test
    public void shouldCorrectReadAndWriteStudentName() throws UnsupportedEncodingException {

        String firstname, lastname;
        if (locale.equals(new Locale("ru", "RU"))) {
            firstname = "Данила";
            lastname = "Черёмухин";
        } else {
            firstname = "Danila";
            lastname = "Cheremukhin";
        }

        when(consoleContext.getIn())
                .thenReturn(prepareInput(firstname))
                .thenReturn(prepareInput(lastname));

        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        PrintStream printStream = new PrintStream(baos);
        given(consoleContext.getOut()).willReturn(printStream);

        studentServiceImpl.newStudent();
        String outputString = baos.toString(String.valueOf(StandardCharsets.UTF_8));
        String[] tokens = outputString.split(EOL);
        int checkingTokenNo = 3;
        String actual = tokens[checkingTokenNo];
        String expected = messageLocalizationService.getLocalMessageParams(CONFIRMATION, new String[]{firstname, lastname});
        assertEquals(expected, actual);
    }

    @DisplayName("валидировать ответы пользователя")
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    public void newStudentValidationOfConversationTest(int noScenario, int checkingTokenNo, String keyOfExpectedMessage, List<String> conversationScenario) throws UnsupportedEncodingException {
        System.out.println("noScenario = " + noScenario + ", checkingTokenNo = " + checkingTokenNo + ", keyOfExpectedMessage = " + keyOfExpectedMessage + " conversationScenario = " + conversationScenario);

        OngoingStubbing<Scanner> os = when(consoleContext.getIn());
        for (String str : conversationScenario) {
            os = os.thenReturn(prepareInput(str));
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        PrintStream printStream = new PrintStream(baos);
        given(consoleContext.getOut()).willReturn(printStream);

        studentServiceImpl.newStudent();
        String outputString = baos.toString(String.valueOf(StandardCharsets.UTF_8));
        String[] tokens = outputString.split(EOL);
        String actual = tokens[checkingTokenNo];
        String expected = messageLocalizationService.getLocalMessageParams(keyOfExpectedMessage, new String[]{conversationScenario.get(0), conversationScenario.get(1)});
        assertEquals(expected, actual);

    }

}

