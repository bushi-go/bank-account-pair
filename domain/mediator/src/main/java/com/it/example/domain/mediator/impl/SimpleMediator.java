package com.it.example.domain.mediator.impl;

import com.it.example.domain.mediator.Action;
import com.it.example.domain.mediator.Handler;
import com.it.example.domain.mediator.Mediator;
import com.it.example.domain.mediator.exception.NoHandlerForActionException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class SimpleMediator implements Mediator {

    private final Set<Handler<? extends Action, ?>> handlers;

    public SimpleMediator(Collection<Handler<? extends Action, ?>> handlers) {
        this.handlers = handlers.stream().collect(Collectors.toUnmodifiableSet());
    }


    @Override
    @SuppressWarnings("unchecked")
    public <R, T extends Action> R execute(T action) {
        Handler<T,R> handler = handlers.stream()
                .filter(handlerCandidate -> handlerCandidate.canHandle(action))
                .findFirst()
                .map(handlerCandidate -> (Handler<T, R>) handlerCandidate)
                .orElseThrow(() -> new NoHandlerForActionException(action));
        return handler.handle(action);

    }
}
