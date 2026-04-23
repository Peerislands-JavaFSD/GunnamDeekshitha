package com.bank.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;

    @Column(name = "account_holder_name", nullable = false)
    private String accountHolderName;

    @Column(name = "balance")
    private double balance;

    @Column(name = "account_type")
    private String accountType;

    public Account() {}
    public Account(String accountHolderName, double balance, String accountType) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }


    public int getAccountId() {
        return accountId;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}