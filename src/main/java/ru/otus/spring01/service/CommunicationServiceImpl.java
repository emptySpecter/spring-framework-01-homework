package ru.otus.spring01.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunicationServiceImpl implements CommunicationService {
    private ConsoleContext ctx;

    @Autowired
    public void setCtx(ConsoleContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void writeLine(String string) {
        ctx.getOut().println(string);
    }

    @Override
    public String readLine() {
        return ctx.getIn().nextLine();
    }
}
