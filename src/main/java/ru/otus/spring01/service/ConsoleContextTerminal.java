package ru.otus.spring01.service;
import lombok.Data;
import lombok.Setter;
import org.jline.terminal.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

@Profile("shell")
@Component
public class ConsoleContextTerminal implements ConsoleContext{

    private Terminal terminal;
    private Scanner in;
    private PrintStream out;

    @Autowired
    public void setTerminal(Terminal terminal) throws UnsupportedEncodingException {
        this.terminal = terminal;
        in = new Scanner(terminal.input(),"UTF-8");
        out = new PrintStream(terminal.output(),true,"UTF-8");
    }

    @Override
    public void setOut(PrintStream printStream) {

    }

    @Override
    public PrintStream getOut() {
        return null;
    }

    @Override
    public void setIn(Scanner scanner) {

    }

    @Override
    public Scanner getIn() {
        return null;
    }
}
