package ru.otus.spring01.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.TestReport;

@Service
@AllArgsConstructor
public class TestingRunnerServiceImpl implements TestingRunnerService {
    private final TestService testService;
    private final StudentService studentService;
    private final TestingService testingService;

    @Override
    public void startTesing() {
        TestReport testReport = testingService.testing(studentService.newStudent(), testService.getTest());
        testingService.printReport(testReport);
    }
}
