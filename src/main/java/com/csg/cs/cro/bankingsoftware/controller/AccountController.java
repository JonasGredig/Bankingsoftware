package com.csg.cs.cro.bankingsoftware.controller;

import com.csg.cs.cro.bankingsoftware.model.AccountEntity;
import com.csg.cs.cro.bankingsoftware.repository.AccountRepository;

import java.util.List;


public class AccountController {

    AccountRepository accountRepository = new AccountRepository();

    public List<AccountEntity> getAccounts(int customerId) {
        return accountRepository.getAccounts(customerId);
    }

}
