package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProps {
    private String language;
    private String country;
    private String fileName;

    public AppProps(@Value("${testfile}") String fileName, @Value("${locale.language:}") String language, @Value("${locale.country:}") String country) {
        this.language = language;
        this.country = country;
        this.fileName = fileName;
    }


    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getTestfileName() {
        return fileName;
    }
}
