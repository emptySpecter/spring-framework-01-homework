package ru.otus.spring01.service;

import ru.otus.spring01.domain.Student;
import ru.otus.spring01.domain.Test;
import ru.otus.spring01.domain.TestReport;

public interface TestingService {
    TestReport testing(Student student, Test test);
    void printReport(TestReport report);
}
