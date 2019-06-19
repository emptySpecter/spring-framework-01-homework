package ru.otus.spring01;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.spring01.dao.TestDao;
import ru.otus.spring01.dao.TestDaoCSV;
import ru.otus.spring01.service.LocalFileNameService;
import ru.otus.spring01.service.TestingRunnerService;

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
    public static TestDao testDao(LocalFileNameService localFileNameService) {

        return new TestDaoCSV(localFileNameService.get());
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
