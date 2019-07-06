package ru.otus.spring01.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.shell.jline.InteractiveShellApplicationRunner;
import org.springframework.stereotype.Service;
import ru.otus.spring01.domain.TestReport;

@Service
public class TestingRunnerServiceImpl implements TestingRunnerService {
    private final TestService testService;
    private final StudentService studentService;
    private final TestingService testingService;
    private final Environment environment;
//    private final ApplicationRunner applicationRunner;

    public TestingRunnerServiceImpl(TestService testService, StudentService studentService, TestingService testingService, Environment environment /*, @Qualifier("interactiveApplicationRunner") ApplicationRunner applicationRunner*/) {
        this.testService = testService;
        this.studentService = studentService;
        this.testingService = testingService;
        this.environment = environment;
       String str = environment.getProperty("spring.shell.interactive.enabled");
//        this.applicationRunner = applicationRunner;
//        ((InteractiveShellApplicationRunner)applicationRunner).disable((ConfigurableEnvironment) environment);
    }

    @Override
    public void startTesing() {
        String[] profiles = environment.getActiveProfiles();
        boolean isShell = false;
        for (int i = 0; i < profiles.length; i++) {
            isShell |= profiles[i].equals("shell");
        }
        if (isShell){
//            try {
//                applicationRunner.run(new DefaultApplicationArguments(new String[]{}));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }else {
            TestReport testReport = testingService.testing(studentService.newStudent(), testService.getTest());
            testingService.printReport(testReport);
        }
    }
}
