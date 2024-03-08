package com.it.example.domain.stubs;

import com.it.example.domain.contract.model.entity.BankAccount;

public interface AccountTestState {
    BankAccount getAccount(String s);

    void init(BankAccount... account);

    void reset();
}
