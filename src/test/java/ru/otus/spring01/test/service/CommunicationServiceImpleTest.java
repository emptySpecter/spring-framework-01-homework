package ru.otus.spring01.test.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring01.service.CommunicationService;
import ru.otus.spring01.service.CommunicationServiceImpl;
import ru.otus.spring01.test.service.consoleproxy.InputProxy;

import java.io.InputStream;

@DisplayName("Проверяем CommunicationServiceImpl")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CommunicationServiceImpleTest {

//    @Autowired
 //   private CommunicationService console = new CommunicationServiceImpl(System.in,System.out);

    @DisplayName("метод writeLine")
    @Test
    public void testWrite() {

    }
    @DisplayName("метод readLine")
    @Test
    public void testRead() {
        InputStream inProxy = new InputProxy("Даниил\n");
        CommunicationService console =  new CommunicationServiceImpl(inProxy,System.out);
        String str = console.readLine();
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println(str);
    }
}
