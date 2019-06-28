package ru.otus.spring01.test.service.consoleproxy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class InputProxy extends ByteArrayInputStream {

    public InputProxy(String inString) {
         super(inString.getBytes(StandardCharsets.UTF_8));
         int cnt = count;
    }
 }
