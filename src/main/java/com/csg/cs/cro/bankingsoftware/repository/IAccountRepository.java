package com.csg.cs.cro.bankingsoftware.repository;

import com.csg.cs.cro.bankingsoftware.model.AccountEntity;

import java.util.List;

public interface IAccountRepository {

    List<AccountEntity> getAccounts(int customerId);

}
