package ru.otus.spring01.test.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring01.service.CommunicationServiceImpl;
import ru.otus.spring01.service.InProxy;
import ru.otus.spring01.service.OutProxy;
import ru.otus.spring01.test.service.consoleproxy.InputProxy;
import ru.otus.spring01.test.service.consoleproxy.OutputProxy;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Проверяем CommunicationServiceImpl")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CommunicationServiceImpleTest {

    @DisplayName("метод writeLine")
    @ParameterizedTest
    @ValueSource(strings = {"Даниил", "Данила"})
    public void testWrite(String outString) throws UnsupportedEncodingException {
        InProxy inProxy = new InputProxy("");
        OutputProxy outProxy = new OutputProxy();
        CommunicationServiceImpl console = new CommunicationServiceImpl(inProxy, outProxy);
        console.writeLine(outString);
        String outputString = outProxy.getBaos().toString(String.valueOf(StandardCharsets.UTF_8));
        assertEquals(outString + "\r\n", outputString);
    }

    @DisplayName("метод readLine")
    @ParameterizedTest
    @ValueSource(strings = {"Даниил", "Данила"})
    public void testRead(String inString) {
        InProxy inProxy = new InputProxy(inString);
        OutProxy outProxy = new OutputProxy();
        CommunicationServiceImpl console = new CommunicationServiceImpl(inProxy, outProxy);
        String outString = console.readLine();
        assertEquals(inString, outString);
    }
}
