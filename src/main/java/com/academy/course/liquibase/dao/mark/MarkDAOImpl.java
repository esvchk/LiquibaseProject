package com.academy.course.liquibase.dao.mark;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Mark;
import com.academy.course.liquibase.model.Student;
import com.academy.course.liquibase.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public class MarkDAOImpl extends DAOImpl<Mark> implements MarkDAO {
    private static final Logger log = LogManager.getLogger(MarkDAOImpl.class);
    private EntityManager em = HibernateUtil.getEntityManager();
    @Override
    public Mark save(Mark mark) throws SQLException {
        try {
            em.getTransaction().begin();
            em.persist(mark);
            em.getTransaction().commit();
            em.close();
        }catch (HibernateException e) {
            log.error("error");
        }
        return mark;
    }
}
