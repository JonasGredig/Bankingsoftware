package com.csg.cs.cro.bankingsoftware.endpoint;

import com.csg.cs.cro.bankingsoftware.controller.TransactionController;
import com.csg.cs.cro.bankingsoftware.dto.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Path("/transaction")
public class TransactionEndpoint {

    private TransactionController transactionController = new TransactionController();

    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getTransactions(@PathParam("customerId") int customerId) {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        Transaction mockTransaction = new Transaction();
        mockTransaction.setAmount(new BigDecimal(500));
        mockTransaction.setId(500);
        mockTransaction.setText("TEST");
        mockTransaction.setTransactionTime(new Timestamp(System.currentTimeMillis()));
        mockTransaction.setType("Transfer");
        transactions.add(mockTransaction);
        return transactions;
    }

    @POST
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction newTransaction(Transaction transaction) {
        return transactionController.newTransaction(transaction);

    }

}
