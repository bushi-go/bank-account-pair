package com.it.example.domain.stubs;

import com.it.example.domain.adapter.BankAccountPrimaryAdapter;
import com.it.example.domain.contract.action.command.DepositCommand;
import com.it.example.domain.contract.port.driving.BankAccountPrimaryPort;
import com.it.example.domain.mediator.Handler;
import com.it.example.domain.mediator.Mediator;
import com.it.example.domain.mediator.impl.SimpleMediator;
import com.it.example.domain.usecase.DepositUseCase;

import java.util.List;

public class TestDi {

    private final static AccountPersistenceTestAdapter accountTestState = new AccountPersistenceTestAdapter();

    private final static BankAccountPrimaryPort bankAccountPrimaryPort = new BankAccountPrimaryAdapter(mediator());

    private static Mediator mediator() {
        return new SimpleMediator(List.of(depositHandler()));
    }

    public static BankAccountPrimaryPort bankAccountPrimaryPort() {
        return bankAccountPrimaryPort;
    }

    public static AccountTestState accountTestState() {
        return accountTestState;
    }

    public static Handler<DepositCommand, Void> depositHandler(){
        return new DepositUseCase(accountTestState);
    }
}
