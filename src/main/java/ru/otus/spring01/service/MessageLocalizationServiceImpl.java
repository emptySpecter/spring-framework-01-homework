package ru.otus.spring01.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageLocalizationServiceImpl implements MessageLocalizationService {
    private String language;
    private String country;
    private MessageSource messageSource;
    private String[] strings = {};
    private Locale locale;


    public MessageLocalizationServiceImpl(MessageSource messageSource, @Value("${locale.language:}") String language, @Value("${locale.country:}") String country) {
        this.language = language;
        this.country = country;
        this.messageSource = messageSource;
        locale = new Locale(language, country);
    }

    @Override
    public String getLocalMessage(String message) {
        return messageSource.getMessage(message, strings, locale);
    }

    @Override
    public String getLocalMessageParams(String message, String[] params) {
        return messageSource.getMessage(message, params, locale);
    }
}
