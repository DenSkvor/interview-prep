package ru.geekbrains.interview.prep.lessons.lesson5.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryGlobal {

    private static SessionFactory sessionFactory;

    public synchronized static SessionFactory getSessionFactory(String url){
        if (sessionFactory == null) sessionFactory = new Configuration().configure(url).buildSessionFactory();
        return sessionFactory;
    }

    public static void close(){
        if(sessionFactory != null) sessionFactory.close();
    }

    private SessionFactoryGlobal(){}
}
