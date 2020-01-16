package com.csg.cs.cro.bankingsoftware.endpoint;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/api")
//The java class declares root resource and provider classes
public class BankingsoftwareApplication extends Application{
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add( HelloWorld.class );
        h.add( CustomerEndpoint.class );
        h.add( AccountEndpoint.class );
        h.add( TransactionEndpoint.class );
        return h;
    }
}
