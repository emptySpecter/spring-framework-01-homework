package ru.otus.spring01.service;

import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class SystemInProxyImpl implements InProxy {

    @Override
    public InputStream getIn() {
        return System.in;
    }
}
