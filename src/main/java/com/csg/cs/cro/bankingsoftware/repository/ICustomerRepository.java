package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.CustomerEntity;

import java.util.List;

public interface ICustomerRepository {

    List<CustomerEntity> getCustomers();
    CustomerEntity getCustomer(Integer id);

}
