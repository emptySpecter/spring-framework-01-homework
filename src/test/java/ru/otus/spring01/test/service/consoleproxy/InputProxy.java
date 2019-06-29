package ru.otus.spring01.test.service.consoleproxy;

import ru.otus.spring01.service.InProxy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class InputProxy implements InProxy {
    private String inString;

    public InputProxy(String inString) {
        this.inString = inString;
    }

    @Override
    public InputStream getIn() {
        return new ByteArrayInputStream(inString.getBytes(StandardCharsets.UTF_8));
    }
}
