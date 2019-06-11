package ru.otus.spring01.service;

import lombok.AllArgsConstructor;
import ru.otus.spring01.domain.TestReport;

@AllArgsConstructor
public class TestingRunnerServiceImpl implements TestingRunnerService {
    private TestService testService;
    private StudentService studentService;
    private TestingService testingService;

    @Override
    public void startTesing() {
        TestReport testReport = testingService.testing(studentService.newStudent(), testService.getTest());
        testingService.printReport(testReport);
    }
}
