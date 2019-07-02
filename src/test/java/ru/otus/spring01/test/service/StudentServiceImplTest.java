package ru.otus.spring01.test.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.spring01.service.ConsoleContext;
import ru.otus.spring01.service.StudentServiceImpl;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.when;

@DisplayName("StudentServiceImpl должен корректно")
@SpringBootTest
public class StudentServiceImplTest {


    @Autowired
    StudentServiceImpl studentServiceImpl;

    @MockBean
    private ConsoleContext consoleContext;


    private static Stream<Arguments> stringIntAndListProvider() {
        return Stream.of(
                arguments("apple", 1, Arrays.asList("a", "b")),
                arguments("lemon", 2, Arrays.asList("x", "y"))
        );
    }

    private static Scanner prepareInput(String inString) {
        return new Scanner(new ByteArrayInputStream(inString.getBytes(StandardCharsets.UTF_8)));
    }

    @DisplayName("валидировать ответы пользователя")
    @ParameterizedTest
    @MethodSource("stringIntAndListProvider")
    public void newStudentValidationOfConversationTest(String keyOfExpectedMessage, int noScenario, List<String> conversationScenario) {
        System.out.println("keyOfExpectedMessage = " + keyOfExpectedMessage + ", noScenario = " + noScenario + " conversationScenario = " + conversationScenario);
        when(consoleContext.getIn())
                .thenReturn(prepareInput(conversationScenario.get(0)))
                .thenReturn(prepareInput(conversationScenario.get(1)));
    }

}

