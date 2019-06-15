package ru.otus.spring01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.spring01.dao.TestDao;
import ru.otus.spring01.dao.TestDaoCSV;
import ru.otus.spring01.service.TestingRunnerService;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

@PropertySource("classpath:application.properties")
@ComponentScan("ru.otus.spring01")
@Configuration
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Main.class);
        context.refresh();
        TestingRunnerService testingRunnerService = context.getBean(TestingRunnerService.class);
        testingRunnerService.startTesing();
    }

    @Bean
    public static TestDao testDao(@Value("${testfile}") String path) {
        Path pth = Paths.get(path);
        URI uri = Paths.get(path).toUri();
        if (!pth.toFile().exists()) {
            try {
                URL url = Main.class.getClassLoader().getResource(path);
                uri = url.toURI();
            } catch (URISyntaxException | NullPointerException e) {
                System.out.println("Test file not found");
                e.printStackTrace();
                System.exit(888);
            }

        }
        return new TestDaoCSV(uri);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms
                = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
