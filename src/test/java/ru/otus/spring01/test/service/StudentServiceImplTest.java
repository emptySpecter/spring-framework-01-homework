package ru.otus.spring01.test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.spring01.service.StudentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class StudentServiceImplTest {

    @Autowired
    StudentService studentService;

    @Test
    void TestTest() {
        String name = "Mary";
        assertEquals(1,1);
        assertTrue(2*2 == 5, "ха-ха");
        assertEquals(name,"Jane");
        assertEquals(name,"Mary");
        assertTrue(2*2 == 3, "ах-ах");
    }

}

