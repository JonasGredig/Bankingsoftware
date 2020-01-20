package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.AccountEntity;
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

    public Integer getAccountId(String iban) {
        if (iban != null && !iban.equals("")) {
            AccountEntity account = em.createQuery("select a from AccountEntity a where a.iban = :iban", AccountEntity.class)
                    .setParameter("iban", iban)
                    .getResultList()
                    .get(0);

            return account.getId();
        } else {
            return 0;
        }
    }

}
