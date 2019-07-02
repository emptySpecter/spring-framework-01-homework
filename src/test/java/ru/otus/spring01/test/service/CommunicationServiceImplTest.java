package ru.otus.spring01.test.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.otus.spring01.service.CommunicationServiceImpl;
import ru.otus.spring01.service.ConsoleContext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@DisplayName("CommunicationServiceImpl должен корректно ")
@SpringBootTest
public class CommunicationServiceImplTest {

    private static final String EOL = System.getProperty("line.separator");
    @MockBean
    private ConsoleContext consoleContext;

    @Autowired
    private CommunicationServiceImpl communicationService;

    @DisplayName("выводить в консоль заданные строки")
    @ParameterizedTest
    @ValueSource(strings = {"Даниил", "Данила"})
    void shouldCorrectWriteStringToOutput(String outString) throws UnsupportedEncodingException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(outString.length());
        given(consoleContext.getOut()).willReturn(new PrintStream(baos));

        communicationService.writeLine(outString);
        String outputString = baos.toString(String.valueOf(StandardCharsets.UTF_8));
        assertEquals(outString + EOL, outputString);
    }

    @DisplayName("читать введенные строки")
    @ParameterizedTest
    @ValueSource(strings = {"Даниил", "Данила"})
    void shouldCorrectReadStringsFromInput(String inString) {
        given(consoleContext.getIn()).willReturn(new Scanner(new ByteArrayInputStream(inString.getBytes(StandardCharsets.UTF_8))));

        String outString = communicationService.readLine();
        assertEquals(inString, outString);
    }

    @Configuration
    @Import(CommunicationServiceImpl.class)
    public static class Config {
    }
}

