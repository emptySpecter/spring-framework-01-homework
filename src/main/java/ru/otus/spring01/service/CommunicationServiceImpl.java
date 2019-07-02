package ru.otus.spring01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunicationServiceImpl implements CommunicationService {
    private final ConsoleContext ctx;

    @Override
    public void writeLine(String string) {
        ctx.getOut().println(string);
    }

    @Override
    public String readLine() {
        return ctx.getIn().nextLine();
    }
}
