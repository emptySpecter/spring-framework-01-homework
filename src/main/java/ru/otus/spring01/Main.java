package ru.otus.spring01;

import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.service.TestingRunnerService;

public class Main {

    public static void main(String[] args) {
        AbstractRefreshableApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        TestingRunnerService testingRunnerService = context.getBean(TestingRunnerService.class);
        testingRunnerService.startTesing();
    }

}
