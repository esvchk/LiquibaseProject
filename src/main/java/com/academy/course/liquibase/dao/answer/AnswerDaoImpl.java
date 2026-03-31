package com.academy.course.liquibase.dao.answer;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Answer;
import com.academy.course.liquibase.model.Mark;
import com.academy.course.liquibase.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public class AnswerDaoImpl extends DAOImpl<Answer> implements AnswerDAO {

    private static final Logger log = LogManager.getLogger(AnswerDaoImpl.class);
    private EntityManager em = HibernateUtil.getEntityManager();

    @Override
    public Answer save(Answer answer) throws SQLException {
        try {
            em.getTransaction().begin();
            em.persist(answer);
            em.getTransaction().commit();
            em.close();
        }catch (HibernateException e) {
            log.error("error");
        }
        return answer;
    }
}