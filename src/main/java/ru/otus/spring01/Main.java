package ru.otus.spring01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.otus.spring01.dao.TestDao;
import ru.otus.spring01.dao.TestDaoCSV;
import ru.otus.spring01.service.TestingRunnerService;

@ComponentScan("ru.otus.spring01")
@Configuration
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Main.class);
        context.refresh();
        TestingRunnerService testingRunnerService = context.getBean(TestingRunnerService.class);
        testingRunnerService.startTesing();
    }

    @Bean
    public TestDao testDao() {
        return new TestDaoCSV("test.csv");
    }
}
