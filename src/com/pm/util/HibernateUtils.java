package com.pm.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
            private static Configuration cfg;
            private static SessionFactory sessionFactory;
            static{
                cfg = new Configuration();
                cfg.configure("hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }
}