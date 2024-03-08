package com.it.example.domain.adapter;

import com.it.example.domain.contract.action.command.DepositCommand;
import com.it.example.domain.contract.port.driving.BankAccountPrimaryPort;
import com.it.example.domain.mediator.Mediator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BankAccountPrimaryAdapter implements BankAccountPrimaryPort {
    private final Mediator mediator;

    @Override
    public void deposit(DepositCommand command) {
        mediator.handle(command);
    }
}
