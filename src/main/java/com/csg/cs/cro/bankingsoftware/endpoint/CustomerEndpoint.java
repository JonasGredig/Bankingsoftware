package com.csg.cs.cro.bankingsoftware.endpoint;

import com.csg.cs.cro.bankingsoftware.controller.CustomerController;
import com.csg.cs.cro.bankingsoftware.model.CustomerEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/customer")
public class CustomerEndpoint {

    private CustomerController customerController;

    public CustomerEndpoint() {
        customerController = new CustomerController();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomerEntity> getCustomers() {
        return customerController.getCustomers();
    }
}
