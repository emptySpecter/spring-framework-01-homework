package ru.otus.spring01.service;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.TestReport;

@ShellComponent
@ConditionalOnProperty(prefix = "spring.shell.interactive", name = "enabled", havingValue = "true")
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

    @ShellMethod(value = "New student command", key = {"s", "student"})
    public void newStudent() {
        student = studentService.newStudent();
        testReport = null;
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
