package ru.otus.spring01.settings;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;

@Component
@ConfigurationProperties("application")
public class AppProps {
    private String testfile;
    private Locale javaLocale;

    public void setTestfile(String testfile) {
        this.testfile = testfile;
    }

    public String getTestfileName() {
        return testfile;
    }

    public void setLocale(Map<String, String> locale) {
        javaLocale = new Locale(locale.get("language"), locale.get("country"));
    }

    public Locale getJavaLocale() {
        return javaLocale;
    }
}
