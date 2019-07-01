package ru.otus.spring01.test.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring01.service.StudentService;

@DisplayName("Проверяем StudentServiceImpl")
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    StudentService studentService;

    @DisplayName("метод newStudent")
    @Test
    void newStudentTest() {
    }

}

