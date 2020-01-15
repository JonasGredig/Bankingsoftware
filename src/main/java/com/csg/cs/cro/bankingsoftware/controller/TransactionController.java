package com.csg.cs.cro.bankingsoftware.controller;

import com.csg.cs.cro.bankingsoftware.dto.Transaction;
import com.csg.cs.cro.bankingsoftware.model.TransactionRecordEntity;
import com.csg.cs.cro.bankingsoftware.repository.TransactionRepository;


public class TransactionController {


    private TransactionRepository transactionRepository = new TransactionRepository();

    public boolean newTransaction(Transaction transaction) {
        return transactionRepository.createTransaction(new TransactionRecordEntity(transaction));
    }
}
