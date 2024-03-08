package com.it.example.domain.contract.port.driving;

import com.it.example.domain.contract.action.command.DepositCommand;

public interface BankAccountPrimaryPort {
    void deposit(DepositCommand command);
}
