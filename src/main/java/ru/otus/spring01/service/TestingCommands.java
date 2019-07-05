package ru.otus.spring01.service;


import lombok.RequiredArgsConstructor;
import org.jline.terminal.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.spring01.domain.Student;

@Profile("shell")
@ShellComponent
public class TestingCommands {
    @Autowired
    private Terminal terminal;

    @ShellMethod(value = "New student command", key = {"ns", "student"})
    public String newStudent() {
        return String.format("+-----------------+");
    }
}
