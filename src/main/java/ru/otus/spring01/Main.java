package ru.otus.spring01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import ru.otus.spring01.service.ConsoleContext;
import ru.otus.spring01.service.ConsoleContextSimple;
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

}
