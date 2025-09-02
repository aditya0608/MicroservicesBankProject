package com.aditya.cards.model.dto;

import java.math.BigDecimal;

public record CreditCardDTO(
        String cardNumber,
        String accountId,
        String cardStatus,
        String cardOwnerName,
        BigDecimal balance,
        String currency
) {
}

