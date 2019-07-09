package ru.otus.spring01.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("spring.shell.interactive")
@Order(InteractiveShellApplicationRunner.PRECEDENCE - 100)
public class ToShellOrNotToShell implements ApplicationRunner {

    private final TestingRunnerService testingRunnerService;
    private boolean shellInteractiveEnabled;

    public ToShellOrNotToShell(TestingRunnerService testingRunnerService) {
        this.testingRunnerService = testingRunnerService;
    }

    public void setEnabled(boolean enabled) {
        shellInteractiveEnabled = enabled;
    }

    @Override
    public void run(ApplicationArguments args){
        if (!shellInteractiveEnabled) {
            testingRunnerService.startTesing();
        }
    }
}
