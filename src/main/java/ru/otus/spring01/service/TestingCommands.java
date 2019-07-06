package ru.otus.spring01.service;


import org.springframework.context.annotation.Profile;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.TestReport;

@Profile("shell")
@ShellComponent
public class TestingCommands {
    private final StudentService studentService;
    private final TestService testService;
    private final TestingService testingService;

    private Student student;
    private TestReport testReport;

    public TestingCommands(StudentService studentService, TestService testService, TestingService testingService) {
        this.studentService = studentService;
        this.testService = testService;
        this.testingService = testingService;
    }

    @ShellMethod(value = "New student command", key = {"ns", "student"})
    public void newStudent() {
        student = studentService.newStudent();
    }

    @ShellMethod(value = "Testing students", key = {"t", "testing"})
    @ShellMethodAvailability(value = "studentExist")
    public void testing() {
        testReport = testingService.testing(student, testService.getTest());
    }

    private Availability studentExist() {
        return student == null ? Availability.unavailable("You must create new student before") : Availability.available();
    }

    @ShellMethod(value = "Show test results", key = {"r", "result"})
    @ShellMethodAvailability(value = "reportExist")
    public void printTestResults() {
        testingService.printReport(testReport);
    }

    private Availability reportExist() {
        return testReport == null ? Availability.unavailable("You must pass test before") : Availability.available();
    }

}
