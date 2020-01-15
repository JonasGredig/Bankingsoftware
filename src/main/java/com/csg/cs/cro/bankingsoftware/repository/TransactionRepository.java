package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.TransactionRecordEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class TransactionRepository implements ITransactionRepository {


    private EntityManager em = Persistence.createEntityManagerFactory("bankingsoftware").createEntityManager();

    public boolean createTransaction(TransactionRecordEntity transaction) {
        if (transaction != null) {
            em.getTransaction().begin();
            em.merge(transaction);
            em.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }
}
