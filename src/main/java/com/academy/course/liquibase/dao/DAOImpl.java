package com.academy.course.liquibase.dao;

import com.academy.course.liquibase.dao.teacher.TeacherDAOImpl;
import com.academy.course.liquibase.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class DAOImpl<T> implements DAO<T> {
    Class<T> tclass;

    private static final Logger log = LogManager.getLogger(TeacherDAOImpl.class);
    private EntityManager em = HibernateUtil.getEntityManager();

    @Override
    public T save(T t) {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("error");
        }
        return t;
    }

    @Override
    public T get(Serializable id) {
        T t = null;
        try {
            em.getTransaction().begin();
            t = em.find(tclass, id);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("error");
        }
        return t;
    }

    @Override
    public void update(T t) {
        try {
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("error");
        }
    }

    @Override
    public void delete(Serializable id) {
        try {
            em.getTransaction().begin();
            em.remove(get(id));
            em.getTransaction().commit();
        } catch (HibernateException e) {
            log.error("error");
        }
    }
}
