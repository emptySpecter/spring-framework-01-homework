package ru.otus.spring01.service;

import lombok.AllArgsConstructor;
import ru.otus.spring01.dao.TestDao;
import ru.otus.spring01.domain.Test;

@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private TestDao dao;

    @Override
    public Test getTest() {
        return dao.getTest();
    }
}
