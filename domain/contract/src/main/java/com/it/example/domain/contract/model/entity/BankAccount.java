package com.it.example.domain.contract.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.math.BigDecimal;

@Builder
@Data
public class BankAccount {

    String bankAccountId;
    BigDecimal balance;

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}
