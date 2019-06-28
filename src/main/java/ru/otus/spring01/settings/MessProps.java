package ru.otus.spring01.settings;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("messages")
@Getter
@Setter
public class MessProps {
    private String[] basenames;
    private String defaultencoding;
}

