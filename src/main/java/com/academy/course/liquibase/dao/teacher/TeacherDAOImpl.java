package com.academy.course.liquibase.dao.teacher;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Teacher;
import com.academy.course.liquibase.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;

public class TeacherDAOImpl extends DAOImpl<Teacher> implements TeacherDAO {

    private static final Logger log = LogManager.getLogger(TeacherDAOImpl.class);
    private EntityManager em = HibernateUtil.getEntityManager();

    @Override
    public Teacher save(Teacher teacher)  {
        try {
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();
            em.close();
        }catch (HibernateException e) {
            log.error("error");
        }
        return teacher;
    }
}
