package com.it.example.rest.model.request;

import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.math.BigDecimal;

@Data
public class DepositRequest {
    private BigDecimal amount;
}
