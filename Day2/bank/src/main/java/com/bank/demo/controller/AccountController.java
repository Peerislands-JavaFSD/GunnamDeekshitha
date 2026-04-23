package com.bank.demo.controller;

import com.bank.demo.model.Account;
import com.bank.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return service.saveAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }
}