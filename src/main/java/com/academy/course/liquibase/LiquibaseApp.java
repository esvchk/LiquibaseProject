package com.academy.course.liquibase;

import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class LiquibaseApp {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();


        em.getTransaction().begin();
        em.getTransaction().commit();

    }
}
