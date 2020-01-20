package com.csg.cs.cro.bankingsoftware.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account", schema = "bank", catalog = "")
public class AccountEntity {
    private Integer id;
    private String iban;
    private BigDecimal balance;
    private BigDecimal overdraft;
    private Integer customerId;

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "IBAN")
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Basic
    @Column(name = "BALANCE")
    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Basic
    @Column(name = "OVERDRAFT")
    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
        this.overdraft = overdraft;
    }

    @Basic
    @Column(name = "CUSTOMER_ID")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (iban != null ? !iban.equals(that.iban) : that.iban != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        if (overdraft != null ? !overdraft.equals(that.overdraft) : that.overdraft != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (iban != null ? iban.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (overdraft != null ? overdraft.hashCode() : 0);
        return result;
    }


}
