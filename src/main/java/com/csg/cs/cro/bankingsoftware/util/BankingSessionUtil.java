package com.csg.cs.cro.bankingsoftware.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class BankingSessionUtil {

    private SessionFactory ourSessionFactory;



    public Session getSession() throws HibernateException {
        if (ourSessionFactory == null) {
            Configuration configuration = new Configuration();
            configuration.configure();

            StandardServiceRegistry standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();

            ourSessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder);
        }
        return ourSessionFactory.openSession();
    }
}
