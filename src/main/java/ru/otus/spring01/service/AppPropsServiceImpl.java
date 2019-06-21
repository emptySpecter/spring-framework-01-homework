package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppPropsServiceImpl implements AppPropsService {
    private String language;
    private String country;
    private String fileName;

    public AppPropsServiceImpl(@Value("${testfile}") String fileName, @Value("${locale.language:}") String language, @Value("${locale.country:}") String country) {
        this.language = language;
        this.country = country;
        this.fileName = fileName;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public String getTestfileName() {
        return fileName;
    }
}
