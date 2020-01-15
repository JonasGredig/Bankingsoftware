package com.csg.cs.cro.bankingsoftware.controller;

import com.csg.cs.cro.bankingsoftware.model.CustomerEntity;
import com.csg.cs.cro.bankingsoftware.repository.CustomerRepository;

import java.util.List;


public class CustomerController {


    private CustomerRepository customerRepository = new CustomerRepository();

    public List<CustomerEntity> getCustomers() {
        return customerRepository.getCustomers();
    }

}
