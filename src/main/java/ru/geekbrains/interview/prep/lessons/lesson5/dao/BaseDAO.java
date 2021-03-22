package ru.geekbrains.interview.prep.lessons.lesson5.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.io.Serializable;


public class BaseDAO<E, ID extends Serializable> {

    private SessionFactory sessionFactory;
    private Class<E> entityClass;

    public BaseDAO(Class<E> entityClass, String url){
        sessionFactory = SessionFactoryGlobal.getSessionFactory(url);
        this.entityClass = entityClass;
    }

    public void saveOrUpdate(E entity){
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        }
    }

    public E findById(ID id){
        E entity = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            entity = session.get(entityClass, id);
            session.getTransaction().commit();
        }
        return entity;
    }


}
