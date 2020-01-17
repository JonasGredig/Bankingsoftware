package com.csg.cs.cro.bankingsoftware.endpoint;

import com.csg.cs.cro.bankingsoftware.controller.AccountController;
import com.csg.cs.cro.bankingsoftware.dto.Account;
import com.csg.cs.cro.bankingsoftware.model.AccountEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/account")
public class AccountEndpoint {

    AccountController accountController;

    public AccountEndpoint() {
        accountController = new AccountController();
    }

    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getCustomers(@PathParam("customerId") int customerId) {

        return accountController.getAccounts(customerId);
    }
}
