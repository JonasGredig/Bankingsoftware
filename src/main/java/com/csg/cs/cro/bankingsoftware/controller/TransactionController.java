package com.csg.cs.cro.bankingsoftware.controller;

import com.csg.cs.cro.bankingsoftware.TransactionType;
import com.csg.cs.cro.bankingsoftware.dto.Transaction;
import com.csg.cs.cro.bankingsoftware.model.AccountEntity;
import com.csg.cs.cro.bankingsoftware.model.TransactionRecordEntity;
import com.csg.cs.cro.bankingsoftware.repository.AccountRepository;
import com.csg.cs.cro.bankingsoftware.repository.TransactionRepository;

import java.sql.Timestamp;


public class TransactionController {


    private TransactionRepository transactionRepository = new TransactionRepository();
    private AccountRepository accountRepository = new AccountRepository();

    public Transaction newTransaction(Transaction transaction) {
        AccountEntity accountEntityUser = accountRepository.getAccount(transactionRepository.getAccountId(transaction.getIban()));

        transaction.setTransactionTime(new Timestamp(System.currentTimeMillis()));
        TransactionRecordEntity transactionRecordEntity = new TransactionRecordEntity(transaction);
        transactionRecordEntity.setAccountId(accountEntityUser.getId());

        if (transaction.getType().equals(TransactionType.DEPOSIT)) {

            accountRepository.updateBalance(transaction.getAccountId(), accountEntityUser.getBalance().add(transaction.getAmount()));

        } else if (transaction.getType().equals(TransactionType.WITHDRAW)) {

            accountRepository.updateBalance(transaction.getAccountId(), accountEntityUser.getBalance().subtract(transaction.getAmount()));

        } else if (transaction.getType().equals(TransactionType.TRANSFER)) {

            AccountEntity accountEntityTo = accountRepository.getAccount(transactionRepository.getAccountId(transaction.getIbanTo()));
            accountRepository.updateBalance(transaction.getAccountId(), accountEntityUser.getBalance().subtract(transaction.getAmount()));
            accountRepository.updateBalance(transaction.getAccountId(), accountEntityTo.getBalance().add(transaction.getAmount()));

        } else {
            throw new RuntimeException("Unbekanner Type");
        }
        transactionRepository.createTransaction(transactionRecordEntity);
        return transaction;
    }
}
