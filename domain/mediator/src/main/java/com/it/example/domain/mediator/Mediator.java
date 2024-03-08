package com.it.example.domain.mediator;

public interface Mediator {
    <R, T extends Action> R execute(T action);
}
