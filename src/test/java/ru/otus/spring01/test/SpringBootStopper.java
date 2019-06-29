package ru.otus.spring01.test;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import ru.otus.spring01.service.*;
import ru.otus.spring01.settings.AppProps;
import ru.otus.spring01.test.service.consoleproxy.InputProxy;
import ru.otus.spring01.test.service.consoleproxy.OutputProxy;

@TestPropertySource("classpath:test.yml")
@EnableConfigurationProperties
@ComponentScan("ru.otus.spring01.settings")
@SpringBootConfiguration
public class SpringBootStopper {

    @Bean
    public MessageLocalizationService messageLocalizationServiceTest(MessageSource messageSource, AppProps appProps) {
        return new MessageLocalizationServiceImpl(messageSource, appProps);
    }

    @Bean
    CommunicationService communicationServiceTest() {
        return new CommunicationServiceImpl(new InputProxy(""), new OutputProxy());
    }

    @Bean
    StudentService studentServiceTest(CommunicationService console, MessageLocalizationService localizationService) {
        return new StudentServiceImpl(console, localizationService);
    }
}
