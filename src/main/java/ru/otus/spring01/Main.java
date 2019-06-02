package ru.otus.spring01;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring01.domain.Question;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.TestReport;
import ru.otus.spring01.service.StudentService;
import ru.otus.spring01.service.TestReportService;
import ru.otus.spring01.service.TestService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

        TestService testService = context.getBean(TestService.class);
        List<Question> questions = testService.getTest().getQuestions();
/*
        for (Question question: questions) {
            System.out.println();
            System.out.println(question);
        }
*/

        StudentService studentService = context.getBean(StudentService.class);
        Student student = studentService.newStudent();

        System.out.println(student);

        TestReportService testReportService = context.getBean(TestReportService.class);
        testReportService.printReport(new TestReport(student, 5, 3));

    }
}
