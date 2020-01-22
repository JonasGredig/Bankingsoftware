package com.csg.cs.cro.bankingsoftware.controller;

import com.csg.cs.cro.bankingsoftware.model.TransactionType;
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
        AccountEntity accountEntity = accountRepository.getAccount(transactionRepository.getAccountId(transaction.getIban()));

        transaction.setTransactionTime(new Timestamp(System.currentTimeMillis()));
        TransactionRecordEntity transactionRecordEntity = new TransactionRecordEntity(transaction);
        transactionRecordEntity.setAccountId(accountEntity.getId());

        if (transaction.getType().equals(TransactionType.DEPOSIT)) {

            accountRepository.updateBalance(accountEntity.getId(), accountEntity.getBalance().add(transaction.getAmount()));
            transactionRepository.createTransaction(transactionRecordEntity);

        } else if (transaction.getType().equals(TransactionType.WITHDRAW)) {

            accountRepository.updateBalance(accountEntity.getId(), accountEntity.getBalance().subtract(transaction.getAmount()));
            transactionRepository.createTransaction(transactionRecordEntity);

        } else if (transaction.getType().equals(TransactionType.TRANSFER)) {

            Integer accountId = transactionRepository.getAccountId(transaction.getIban());
            Integer toAccountId = transactionRepository.getAccountId(transaction.getIbanTo());
            AccountEntity toAccountEntity = accountRepository.getAccount(toAccountId);

            accountRepository.updateBalance(accountId, accountEntity.getBalance().subtract(transaction.getAmount()));
            accountRepository.updateBalance(toAccountId, toAccountEntity.getBalance().add(transaction.getAmount()));

            TransactionRecordEntity outTransactionRecordEntity = transactionRecordEntity;
            transactionRepository.createTransactions(transactionRecordEntity, outTransactionRecordEntity);

        } else {
            throw new RuntimeException("Unbekanner Type");
        }

        return transaction;
    }
}
