package com.csg.cs.cro.bankingsoftware.controller;

import com.csg.cs.cro.bankingsoftware.dto.Account;
import com.csg.cs.cro.bankingsoftware.model.AccountEntity;
import com.csg.cs.cro.bankingsoftware.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;


public class AccountController {

    AccountRepository accountRepository = new AccountRepository();

    public List<Account> getAccounts(int customerId) {
        ArrayList<Account> accounts = new ArrayList<Account>();
        for (AccountEntity accountEntity : accountRepository.getAccounts(customerId)) {
            accounts.add(new Account(accountEntity));
        }
        return accounts;
    }

}
