package com.it.example.domain.usecase;

import com.it.example.domain.contract.action.query.ExampleQuery;
import com.it.example.domain.contract.model.dto.ExampleDto;
import com.it.example.domain.contract.model.entity.ExampleEntity;
import com.it.example.domain.contract.port.driven.ExamplePersistencePort;
import com.it.example.domain.mediator.Action;
import com.it.example.domain.mediator.Handler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExampleReadHandler implements Handler<ExampleQuery, ExampleDto> {

    private final ExamplePersistencePort persistencePort;

    @Override
    public ExampleDto handle(ExampleQuery action) {
        ExampleEntity entity = persistencePort.findById(action.id());
        return new ExampleDto();
    }

    @Override
    public <P extends Action> boolean canHandle(P action) {
        return action instanceof ExampleQuery;
    }
}
