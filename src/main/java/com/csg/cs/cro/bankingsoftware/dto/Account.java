package com.csg.cs.cro.bankingsoftware.dto;

import com.csg.cs.cro.bankingsoftware.model.AccountEntity;

import java.math.BigDecimal;

public class Account {

    private String iban;
    private BigDecimal balance;
    private BigDecimal overdraft;

    public Account(AccountEntity accountEntity) {
        this.iban = accountEntity.getIban();
        this.balance = accountEntity.getBalance();
        this.overdraft = accountEntity.getOverdraft();
    }

    public Account() {
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal amount) {
        this.balance = amount;
    }

    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }
}
