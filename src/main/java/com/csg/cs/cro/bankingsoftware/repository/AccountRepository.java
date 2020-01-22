package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.AccountEntity;
import com.sun.javafx.binding.Logging;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class AccountRepository implements IAccountRepository {

    private EntityManager em = Persistence.createEntityManagerFactory("bankingsoftware").createEntityManager();

    public List<AccountEntity> getAccounts(int customerId) {
        try {
            return em.createQuery("Select a from AccountEntity a", AccountEntity.class).getResultList();
        } catch (Exception e) {
            Logging.getLogger().warning(e.getStackTrace().toString());
            return Arrays.asList(new AccountEntity());
        }
    }

    public AccountEntity getAccount(int accountId) {
        try {
            return em.createQuery("Select a from AccountEntity a where a.id = :accountId", AccountEntity.class)
                    .setParameter("accountId", accountId)
                    .getResultList()
                    .get(0);
        } catch (Exception e) {
            Logging.getLogger().warning(e.getStackTrace().toString());
            return new AccountEntity();
        }
    }



    public boolean updateBalance(Integer accountId, BigDecimal balance) {
        try {
            em.getTransaction().begin();
            em.createQuery("update AccountEntity a set a.balance = :balance where a.id = :accountId", AccountEntity.class)
                    .setParameter("balance", balance)
                    .setParameter("accountId", accountId)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            Logging.getLogger().warning(e.getStackTrace().toString());
            return false;
        }

        return true;
    }


}
