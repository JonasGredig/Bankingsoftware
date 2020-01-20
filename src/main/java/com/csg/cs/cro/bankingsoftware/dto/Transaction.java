package com.csg.cs.cro.bankingsoftware.dto;

import com.csg.cs.cro.bankingsoftware.model.TransactionRecordEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Transaction implements Serializable {
    private Integer id;
    private String type;
    private String text;
    private BigDecimal amount;
    private Timestamp transactionTime;
    private String iban;
    private String ibanTo;
    private Integer accountId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getIbanTo() {
        return ibanTo;
    }

    public void setIbanTo(String ibanTo) {
        this.ibanTo = ibanTo;
    }
}
