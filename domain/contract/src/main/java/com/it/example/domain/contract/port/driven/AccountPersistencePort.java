package com.it.example.domain.contract.port.driven;

import com.it.example.domain.contract.model.entity.BankAccount;

import java.util.Optional;

public interface AccountPersistencePort {
    Optional<BankAccount> load(String s);

    void save(BankAccount account);
}
