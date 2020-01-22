package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.AccountEntity;
import com.csg.cs.cro.bankingsoftware.model.TransactionRecordEntity;
import com.sun.javafx.binding.Logging;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;


public class TransactionRepository implements ITransactionRepository {


    private EntityManager em = Persistence.createEntityManagerFactory("bankingsoftware").createEntityManager();

    public boolean createTransaction(TransactionRecordEntity transaction) {
        try {
            transaction.setId(0);
            if (transaction != null) {
                em.getTransaction().begin();
                em.merge(transaction);
                em.getTransaction().commit();

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Logging.getLogger().warning(e.getStackTrace().toString());
            return false;
        }
    }

    public boolean createTransactions(TransactionRecordEntity transaction1, TransactionRecordEntity transaction2) {
        try {
            transaction1.setId(0);
            transaction2.setId(0);
            if (transaction1 != null && transaction2 != null) {
                em.getTransaction().begin();
                em.merge(transaction1);
                em.merge(transaction2);
                em.getTransaction().commit();

                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Logging.getLogger().warning(e.getStackTrace().toString());
            return false;
        }
    }

    public Integer getAccountId(String iban) {
        try {
            if (iban != null && !iban.equals("")) {
                AccountEntity account = em.createQuery("select a from AccountEntity a where a.iban = :iban", AccountEntity.class)
                        .setParameter("iban", iban)
                        .getResultList()
                        .get(0);

                return account.getId();
            } else {
                return 0;
            }
        } catch (Exception e) {
            Logging.getLogger().warning(e.getStackTrace().toString());
            return 0;
        }
    }

}
