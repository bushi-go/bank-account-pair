package com.it.example.domain.mediator.stubs;

import com.it.example.domain.mediator.Handler;
import com.it.example.domain.mediator.Mediator;
import com.it.example.domain.mediator.impl.SimpleMediator;

import java.util.List;

public class TestMediatorFactory {

    public static Mediator createMediator(List<Handler<?,?>> handlers) {
        return new SimpleMediator(handlers);
    }
}
