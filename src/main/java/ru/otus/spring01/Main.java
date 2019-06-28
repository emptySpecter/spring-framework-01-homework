package ru.otus.spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.spring01.service.TestingRunnerService;
import ru.otus.spring01.settings.MessProps;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        TestingRunnerService testingRunnerService = context.getBean(TestingRunnerService.class);
        testingRunnerService.startTesing();
    }

    @Bean
    public MessageSource messageSource(MessProps messProps) {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasenames(messProps.getBasenames());
        ms.setDefaultEncoding(messProps.getDefaultencoding());
        return ms;
    }
}
