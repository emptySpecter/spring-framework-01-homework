package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class AppProps {
    private String localeLanguage;
    private String localeCountry;
    private String testfile;

//    public AppProps(@Value("${testfile}") String fileName, @Value("${locale.localeLanguage:}") String localeLanguage, @Value("${locale.localeCountry:}") String localeCountry) {
//        this.localeLanguage = localeLanguage;
//        this.localeCountry = localeCountry;
//        this.testfile = fileName;
//    }


    public String getLocaleLanguage() {
        return localeLanguage;
    }

    public String getLocaleCountry() {
        return localeCountry;
    }

    public String getTestfileName() {
        return testfile;
    }
}
