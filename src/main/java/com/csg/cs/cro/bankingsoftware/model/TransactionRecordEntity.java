package com.csg.cs.cro.bankingsoftware.model;

import com.csg.cs.cro.bankingsoftware.dto.Transaction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "transaction_record", schema = "bank", catalog = "")
public class TransactionRecordEntity {
    private Integer id;
    private String type;
    private String text;
    private BigDecimal amount;
    private Timestamp transactionTime;
    private Integer accountId;

    public TransactionRecordEntity() {

    }

    public TransactionRecordEntity(Transaction transaction) {
        this.id = transaction.getId();
        this.type=transaction.getType();
        this.text= transaction.getText();
        this.amount= transaction.getAmount();
        this.transactionTime = transaction.getTransactionTime();
        this.accountId = transaction.getAccountId();
    }

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TYPE")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "TEXT")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "AMOUNT")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "TRANSACTION_TIME")
    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }

    @Basic
    @Column(name = "ACCOUNT_ID")
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionRecordEntity that = (TransactionRecordEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (transactionTime != null ? !transactionTime.equals(that.transactionTime) : that.transactionTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (transactionTime != null ? transactionTime.hashCode() : 0);
        return result;
    }
}
