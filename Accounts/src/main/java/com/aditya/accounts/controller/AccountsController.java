package com.aditya.accounts.controller;

import com.aditya.accounts.model.dto.AccountConfiguration;
import com.aditya.accounts.model.dto.AccountDTO;
import com.aditya.accounts.model.dto.AccountType;
import com.aditya.accounts.model.entity.Account;
import com.aditya.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @Autowired
    private Environment environment;
    @Autowired
    private  AccountService accountService;

    @Value("${build.version}")
    private  String buildVersion;

    @Autowired
    private AccountConfiguration accountConfiguration;

    /**
     * Example: GET /api/accounts?accountType=SAVINGS&userId=adishars
     */
    @GetMapping
    public ResponseEntity<List<Account>> fetchAllAccounts(@RequestParam("accountType")  String accountType,@RequestParam("userId")  String userId) {
        List<Account> accounts = accountService.getAccountsByType(AccountType.valueOf(accountType),userId);
        return ResponseEntity.ok(accounts);
    }

    /**
     * POST /api/accounts
     */
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO accountDTO) {
        Account saved = accountService.createAccount(accountDTO);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @GetMapping("/maven-version")
    public ResponseEntity<String> getMavenVersion()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("MAVEN_HOME"));
    }

    @GetMapping("/email")
    public ResponseEntity<String> getEmail()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(accountConfiguration.getContact().get("email"));
    }
    @GetMapping("/config")
    public ResponseEntity<AccountConfiguration> getConfiguration()
    {
        return  ResponseEntity.status(HttpStatus.OK).body(accountConfiguration);
    }
}
