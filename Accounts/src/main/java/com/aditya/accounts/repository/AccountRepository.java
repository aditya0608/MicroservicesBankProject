package com.aditya.accounts.repository;


import com.aditya.accounts.model.dto.AccountType;
import com.aditya.accounts.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByAccountTypeAndUserId(AccountType accountType,String userId);
}
