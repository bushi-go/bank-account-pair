package com.it.example.domain.contract.port.driving;

import com.it.example.domain.contract.action.command.ExampleCommand;
import com.it.example.domain.contract.action.query.ExampleQuery;
import com.it.example.domain.contract.model.dto.ExampleDto;

public interface ExamplePort {
    void exampleWrite(ExampleCommand command);
    ExampleDto exampleRead(ExampleQuery query);
}
