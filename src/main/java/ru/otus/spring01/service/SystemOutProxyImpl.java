package ru.otus.spring01.service;

import org.springframework.stereotype.Component;

import java.io.PrintStream;

@Component
public class SystemOutProxyImpl implements OutProxy {

    @Override
    public PrintStream getOut() {
        return System.out;
    }
}
