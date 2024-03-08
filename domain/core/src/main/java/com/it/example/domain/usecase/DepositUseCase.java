package com.it.example.domain.usecase;

import com.it.example.domain.contract.action.command.DepositCommand;
import com.it.example.domain.contract.model.entity.BankAccount;
import com.it.example.domain.contract.port.driven.AccountPersistencePort;
import com.it.example.domain.exception.BankAccountNotFoundException;
import com.it.example.domain.mediator.Action;
import com.it.example.domain.mediator.Handler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepositUseCase implements Handler<DepositCommand, Void> {

    private final AccountPersistencePort persistencePort;

    @Override
    public Void handle(DepositCommand action) {
        BankAccount account = persistencePort.load(action.bankAccountId())
                .orElseThrow(BankAccountNotFoundException::new);
        account.deposit(action.amount());
        persistencePort.save(account);
        return null;
    }

    @Override
    public <P extends Action> boolean canHandle(P action) {
        return action instanceof DepositCommand;
    }
}
