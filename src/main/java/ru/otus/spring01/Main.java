package ru.otus.spring01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.domain.TestReport;
import ru.otus.spring01.service.StudentService;
import ru.otus.spring01.service.TestService;
import ru.otus.spring01.service.TestingService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        TestService testService = context.getBean(TestService.class);
        StudentService studentService = context.getBean(StudentService.class);
        TestingService testingService = context.getBean(TestingService.class);

        TestReport testReport = testingService.Testing(studentService.newStudent(), testService.getTest());
        testingService.printReport(testReport);

    }
}
