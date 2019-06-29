package ru.otus.spring01.test.service.consoleproxy;

import ru.otus.spring01.service.OutProxy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputProxy implements OutProxy {
    private ByteArrayOutputStream baos = new ByteArrayOutputStream(512);

    public ByteArrayOutputStream getBaos() {
        return baos;
    }

    @Override
    public PrintStream getOut() {
        return new PrintStream(baos);
    }

}
