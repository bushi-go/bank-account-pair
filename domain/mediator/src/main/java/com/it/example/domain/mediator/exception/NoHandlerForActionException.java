package com.it.example.domain.mediator.exception;

import com.it.example.domain.mediator.Action;

import java.io.Serial;

public class NoHandlerForActionException extends IllegalArgumentException {

    private static final String MESSAGE = "No handler for action %s";

    @Serial
    private static final long serialVersionUID = 8414951065917101919L;

    public <T extends Action> NoHandlerForActionException(T action) {
        super(MESSAGE.formatted(action.getClass().getSimpleName()));
    }
}
