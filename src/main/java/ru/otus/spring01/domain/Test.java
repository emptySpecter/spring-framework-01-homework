package ru.otus.spring01.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Test {
    @Getter
    private final List<Question> questions;
}
