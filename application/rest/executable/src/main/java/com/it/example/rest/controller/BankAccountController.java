package com.it.example.rest.controller;

import com.it.example.domain.contract.action.command.DepositCommand;
import com.it.example.domain.contract.port.driving.BankAccountPrimaryPort;
import com.it.example.rest.model.request.DepositRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/account")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountPrimaryPort port;

    @PatchMapping("/{accountId}/deposit")
    ResponseEntity<Void> deposit(String accountId, DepositRequest request){
        log.info("Received deposit request for account {}", accountId);
        DepositCommand command = new DepositCommand(accountId, request.getAmount());
        port.deposit(command);
        return ResponseEntity.noContent().build();
    }
}
