package com.it.example.domain.mediator;

public interface Handler<T extends Action, R> {
    R handle(T action);
    <P extends Action> boolean canHandle(P action);
}
