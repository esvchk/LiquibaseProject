package com.academy.course.liquibase.dao;

import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

public class DAOImpl<T> implements DAO<T> {

    @Override
    public T save(T t) {
        try{
            EntityManager entityManager = HibernateUtil.getEntityManager();
            entityManager.getTransaction();
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public T get(Serializable id) {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public int delete(Serializable id) {
        return 0;
    }
}
