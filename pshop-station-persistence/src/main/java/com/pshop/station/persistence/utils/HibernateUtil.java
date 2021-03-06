package com.pshop.station.persistence.utils;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("/com/bstore/services/persistence/config/hibernate.cfg.xml")
                    .buildSessionFactory();
        } catch (HibernateException he) {
            System.err.println("Ocurrió un error en la inicialización de la SessionFactory: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
     public static void shutdown() {
        getSessionFactory().close();
    }
}