package ru.otus.spring01.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring01.settings.AppProps;

import java.util.Locale;

@Service
@ConfigurationProperties("messages")
public class MessageLocalizationServiceImpl extends ReloadableResourceBundleMessageSource implements MessageLocalizationService {
    private final Locale locale;
    private final String[] strings = {};

    public MessageLocalizationServiceImpl(AppProps appPropsService) {
        locale = appPropsService.getJavaLocale();
    }

    @Override
    public String getLocalMessage(String message) {
        return getMessage(message, strings, locale);
    }

    @Override
    public String getLocalMessageParams(String message, String[] params) {
        return getMessage(message, params, locale);
    }
}
