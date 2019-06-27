package ru.otus.spring01.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("application")
public class AppProps {
    private String testfile;
    private Map<String, String> locale;
    private Map<String, String> messagesource;

    public void setLocale(Map<String, String> locale) {
        this.locale = locale;
    }

    public String getLocaleLanguage() {
        return locale.get("language");
    }

    public String getLocaleCountry() {
        return locale.get("country");
    }

    public void setTestfile(String testfile) {
        this.testfile = testfile;
    }

    public String getTestfileName() {
        return testfile;
    }

    public Map<String, String> getMessagesource() {
        return messagesource;
    }

    public void setMessagesource(Map<String, String> messagesource) {
        this.messagesource = messagesource;
    }
}
