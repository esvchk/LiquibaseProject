package com.academy.course.liquibase.dao.course;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;

public class CourseDAOImpl extends DAOImpl<Course> implements CourseDAO {

    private static final Logger log = LogManager.getLogger(CourseDAOImpl.class);
    private EntityManager em = HibernateUtil.getEntityManager();
    @Override
    public Course save(Course course) throws SQLException {
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            em.close();
        }catch (HibernateException e) {
            log.error("error");
        }
        return course;
    }

    @Override
    public Course get(Serializable id) throws SQLException {
        return null;
    }

    @Override
    public void update(Course course) throws SQLException {

    }

    @Override
    public int delete(Serializable id) throws SQLException {
        return 0;
    }
}
