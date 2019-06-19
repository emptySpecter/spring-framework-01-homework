package ru.otus.spring01.service;

public interface MessageLocalizationService {
    String getLocalMessage(String message);

    String getLocalMessageParams(String message, String[] strings);
}
