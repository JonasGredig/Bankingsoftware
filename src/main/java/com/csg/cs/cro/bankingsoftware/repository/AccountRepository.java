package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.dto.Transaction;
import com.csg.cs.cro.bankingsoftware.model.AccountEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class AccountRepository implements IAccountRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("bankingsoftware").createEntityManager();

    public List<AccountEntity> getAccounts(int customerId) {
        return em.createQuery("Select a from AccountEntity a", AccountEntity.class).getResultList();
    }

    public AccountEntity getAccount(int accountId) {
        return em.createQuery("Select a from AccountEntity a where a.id = :accountId", AccountEntity.class)
                .setParameter("accountId", accountId)
                .getResultList()
                .get(0);
    }



    public boolean updateBalance(Integer accountId, BigDecimal balance) {
        em.getTransaction().begin();
        em.createQuery("update AccountEntity a set a.balance = :balance where a.id = :accountId", AccountEntity.class)
                .setParameter("balance", balance)
                .setParameter("accountId", accountId)
                .executeUpdate();
        em.getTransaction().commit();
        return true;
    }


}
