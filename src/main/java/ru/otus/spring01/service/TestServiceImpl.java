package ru.otus.spring01.service;

import ru.otus.spring01.dao.TestDao;
import ru.otus.spring01.domain.Test;

public class TestServiceImpl implements TestService {

    private TestDao dao;

    public TestServiceImpl(TestDao dao) {
        this.dao = dao;
    }

    @Override
    public Test getTest() {
        return dao.getTest();
    }
}
