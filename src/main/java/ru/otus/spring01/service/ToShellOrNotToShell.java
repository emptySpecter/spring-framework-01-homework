package ru.otus.spring01.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "spring.shell.interactive", name = "enabled", havingValue = "false")
@Order(InteractiveShellApplicationRunner.PRECEDENCE - 100)
public class ToShellOrNotToShell implements ApplicationRunner {

    private final TestingRunnerService testingRunnerService;

    public ToShellOrNotToShell(TestingRunnerService testingRunnerService) {
        this.testingRunnerService = testingRunnerService;
    }

    @Override
    public void run(ApplicationArguments args) {
        testingRunnerService.startTesing();
    }
}
