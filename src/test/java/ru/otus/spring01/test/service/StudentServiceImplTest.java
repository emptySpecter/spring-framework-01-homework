package ru.otus.spring01.test.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring01.service.StudentService;

@DisplayName("Проверяем StudentServiceImpl")
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StudentServiceImplTest {

    @Autowired
    StudentService studentService;

    @DisplayName("метод newStudent")
    @Test
    void newStudentTest() {
    }

}

