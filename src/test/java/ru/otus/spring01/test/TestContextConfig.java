package ru.otus.spring01.test;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import ru.otus.spring01.service.CommunicationServiceImpl;
import ru.otus.spring01.service.MessageLocalizationServiceImpl;
import ru.otus.spring01.service.StudentServiceImpl;

@SpringBootConfiguration
@EnableConfigurationProperties
@Import({CommunicationServiceImpl.class, MessageLocalizationServiceImpl.class, StudentServiceImpl.class})
@ComponentScan("ru.otus.spring01.settings")
public class TestContextConfig {
}
