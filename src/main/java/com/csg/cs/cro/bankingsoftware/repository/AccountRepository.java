package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.AccountEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class AccountRepository implements IAccountRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("bankingsoftware").createEntityManager();

    public List<AccountEntity> getAccounts(int customerId) {
        return em.createQuery("Select a from AccountEntity a", AccountEntity.class).getResultList();
    }
}
