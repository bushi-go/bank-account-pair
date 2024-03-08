package com.it.example.domain.contract.action.command;

import com.it.example.domain.mediator.Action;

import java.math.BigDecimal;

public record DepositCommand(String bankAccountId, BigDecimal amount) implements Action {

}
