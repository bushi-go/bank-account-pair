package com.it.example.domain.driving;

import com.it.example.domain.contract.action.command.DepositCommand;
import com.it.example.domain.contract.port.driving.BankAccountPrimaryPort;
import com.it.example.domain.contract.model.entity.BankAccount;
import com.it.example.domain.stubs.AccountTestState;
import com.it.example.domain.stubs.TestDi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class DepositUseCaseTest {

    BankAccountPrimaryPort underTest = TestDi.bankAccountPrimaryPort();
    private AccountTestState testState = TestDi.accountTestState();

    @BeforeEach
    void setup(){
        testState.reset();
    }

    @Test
    void should_deposit_when_amount_is_ok() {

        // Given
        String accountId = UUID.randomUUID().toString();
        DepositCommand command = new DepositCommand(accountId, BigDecimal.valueOf(1000));
        BigDecimal expectedBalance = BigDecimal.valueOf(1000);
        BankAccount account = BankAccount.builder().bankAccountId(accountId).balance(BigDecimal.ZERO).build();
        testState.init(account);

        // When
        underTest.deposit(command);

        // Then
        assertThat(testState.getAccount(command.bankAccountId())).extracting(BankAccount::getBalance).isEqualTo(expectedBalance);
    }
}
