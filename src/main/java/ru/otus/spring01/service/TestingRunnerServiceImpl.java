package ru.otus.spring01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.TestReport;

@Service
@ConfigurationProperties("spring.shell.interactive")
@RequiredArgsConstructor
public class TestingRunnerServiceImpl implements TestingRunnerService {
    private final TestService testService;
    private final StudentService studentService;
    private final TestingService testingService;

    private boolean shellInteractiveEnabled;

    public void setEnabled(boolean enabled) {
        shellInteractiveEnabled = enabled;
    }

    @Override
    public void startTesing() {
        if (!shellInteractiveEnabled) {
            TestReport testReport = testingService.testing(studentService.newStudent(), testService.getTest());
            testingService.printReport(testReport);
        }
    }
}
