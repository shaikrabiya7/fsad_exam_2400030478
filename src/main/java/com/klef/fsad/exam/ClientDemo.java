package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        // Insert record
        Transaction tx = session.beginTransaction();
        Transport t1 = new Transport("Bus", new java.util.Date(), "Running");
        session.persist(t1);
        tx.commit();

        // View all records using HQL
        List<Transport> transports = session.createQuery("FROM Transport", Transport.class).getResultList();
        for (Transport t : transports) {
            System.out.println(t);
        }

        session.close();
        sf.close();
    }
}