package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.CustomerEntity;
import com.csg.cs.cro.bankingsoftware.util.BankingSessionUtil;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;


public class CustomerRepository implements ICustomerRepository {


    private EntityManager em = Persistence.createEntityManagerFactory("bankingsoftware").createEntityManager();

    public List<CustomerEntity> getCustomers() {
        return em.createQuery("Select c from CustomerEntity c", CustomerEntity.class).getResultList();
    }

    public CustomerEntity getCustomer(Integer id) {
        return em.find(CustomerEntity.class, id);
    }
}
