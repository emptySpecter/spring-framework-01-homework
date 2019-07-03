package ru.otus.spring01.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Student {
    private final String firstName;
    private final String lastName;
}
