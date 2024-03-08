package com.it.example.domain.stubs;

import com.it.example.domain.contract.model.entity.BankAccount;
import com.it.example.domain.contract.port.driven.AccountPersistencePort;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AccountPersistenceTestAdapter implements AccountTestState, AccountPersistencePort {

    private final Map<String, BankAccount> state = new ConcurrentHashMap<>();

    @Override
    public BankAccount getAccount(String s) {
        return state.get(s);
    }

    @Override
    public void init(BankAccount... accounts) {
        state.putAll(Arrays.stream(accounts).collect(Collectors.toMap(BankAccount::getBankAccountId, Function.identity())));
    }

    @Override
    public void reset() {
        state.clear();
    }

    @Override
    public Optional<BankAccount> load(String s) {
        return Optional.ofNullable(state.get(s));
    }

    @Override
    public void save(BankAccount account) {
        state.put(account.getBankAccountId(), account);
    }
}
