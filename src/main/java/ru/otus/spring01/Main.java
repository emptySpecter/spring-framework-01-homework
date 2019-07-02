package ru.otus.spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.otus.spring01.service.ConsoleContext;
import ru.otus.spring01.service.TestingRunnerService;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
        TestingRunnerService testingRunnerService = context.getBean(TestingRunnerService.class);
        testingRunnerService.startTesing();
    }

    @Bean
    public ConsoleContext consoleContext() {
        return new ConsoleContext(System.out, new Scanner(System.in, String.valueOf(StandardCharsets.UTF_8)));
    }
}
