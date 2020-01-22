package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.CustomerEntity;
import com.csg.cs.cro.bankingsoftware.util.BankingSessionUtil;
import com.sun.javafx.binding.Logging;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;


public class CustomerRepository implements ICustomerRepository {


    private EntityManager em = Persistence.createEntityManagerFactory("bankingsoftware").createEntityManager();

    public List<CustomerEntity> getCustomers() {
        try {
            return em.createQuery("Select c from CustomerEntity c", CustomerEntity.class).getResultList();
        } catch (Exception e) {
            Logging.getLogger().warning(e.getStackTrace().toString());
            return Arrays.asList(new CustomerEntity());
        }
    }

    public CustomerEntity getCustomer(Integer id) {

        try {
            return em.find(CustomerEntity.class, id);
        } catch (Exception e) {
            Logging.getLogger().warning(e.getStackTrace().toString());
            return new CustomerEntity();
        }
    }
}
