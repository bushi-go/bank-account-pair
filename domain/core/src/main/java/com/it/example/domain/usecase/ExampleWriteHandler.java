package com.it.example.domain.usecase;

import com.it.example.domain.contract.action.command.ExampleCommand;
import com.it.example.domain.contract.model.entity.ExampleEntity;
import com.it.example.domain.contract.port.driven.ExamplePersistencePort;
import com.it.example.domain.mediator.Action;
import com.it.example.domain.mediator.Handler;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class ExampleWriteHandler implements Handler<ExampleCommand, Void> {

    private final ExamplePersistencePort persistencePort;

    @Override
    public Void handle(ExampleCommand action) {
        persistencePort.save(new ExampleEntity(UUID.randomUUID().toString()));
        return null;
    }

    @Override
    public <P extends Action> boolean canHandle(P action) {
        return action instanceof ExampleCommand;
    }
}
