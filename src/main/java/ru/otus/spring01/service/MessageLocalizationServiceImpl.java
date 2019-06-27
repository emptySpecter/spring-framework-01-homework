package ru.otus.spring01.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageLocalizationServiceImpl implements MessageLocalizationService {
    private final String language;
    private final String country;
    private final MessageSource messageSource;
    private final Locale locale;
    private final String[] strings = {};


    public MessageLocalizationServiceImpl(MessageSource messageSource, AppProps appPropsService) {
        this.language = appPropsService.getLocaleLanguage();
        this.country = appPropsService.getLocaleCountry();
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
