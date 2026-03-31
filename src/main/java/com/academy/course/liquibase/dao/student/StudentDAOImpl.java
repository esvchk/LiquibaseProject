package com.academy.course.liquibase.dao.student;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Student;
import com.academy.course.liquibase.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public class StudentDAOImpl extends DAOImpl<Student> implements StudentDAO{

    private static final Logger log = LogManager.getLogger(StudentDAOImpl.class);
    private EntityManager em = HibernateUtil.getEntityManager();

    @Override
    public Student save(Student student) throws SQLException {
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            em.close();
        }catch (HibernateException e) {
            log.error("error");
        }
        return student;
    }


}
