package com.aditya.accounts.model.dto;

import com.aditya.accounts.model.entity.Account;

public record AccountDTO(String accountId, AccountType accountType, String userId) {
}
