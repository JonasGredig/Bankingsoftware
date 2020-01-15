package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.TransactionRecordEntity;

public interface ITransactionRepository {

    boolean createTransaction(TransactionRecordEntity transaction);

}
