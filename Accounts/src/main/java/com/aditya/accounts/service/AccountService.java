package com.aditya.accounts.service;

import com.aditya.accounts.model.dto.AccountDTO;
import com.aditya.accounts.model.dto.AccountType;
import com.aditya.accounts.model.entity.Account;
import com.aditya.accounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private  AccountRepository accountRepository;


    public List<Account> getAccountsByType(AccountType type,String userId) {
        return accountRepository.findByAccountTypeAndUserId(type,userId);
    }

    public Account createAccount(AccountDTO accountDTO) {
        Account account=new Account();
        account.setAccountId(accountDTO.accountId());
        account.setAccountType(accountDTO.accountType());
        account.setUserId(accountDTO.userId());
        return accountRepository.save(account);
    }
}
