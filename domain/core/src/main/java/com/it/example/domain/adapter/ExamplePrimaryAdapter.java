package com.it.example.domain.adapter;

import com.it.example.domain.contract.action.command.ExampleCommand;
import com.it.example.domain.contract.action.query.ExampleQuery;
import com.it.example.domain.contract.model.dto.ExampleDto;
import com.it.example.domain.contract.port.driving.ExamplePort;
import com.it.example.domain.mediator.Mediator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExamplePrimaryAdapter implements ExamplePort {

    private final Mediator mediator;


    @Override
    public void exampleWrite(ExampleCommand command) {
        mediator.execute(command);
    }

    @Override
    public ExampleDto exampleRead(ExampleQuery query) {
        return mediator.execute(query);
    }
}
