package ru.otus.spring01.service;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.TestReport;

@AllArgsConstructor
@Service
public class TestingRunnerServiceImpl implements TestingRunnerService {
    private final TestService testService;
    private final StudentService studentService;
    private final TestingService testingService;
    private final Environment environment;


    @Override
    public void startTesing() {
        String str = environment.getProperty("spring.shell.interactive.enabled");
        if (!Boolean.parseBoolean(str)) {
            TestReport testReport = testingService.testing(studentService.newStudent(), testService.getTest());
            testingService.printReport(testReport);
        }
    }
}
