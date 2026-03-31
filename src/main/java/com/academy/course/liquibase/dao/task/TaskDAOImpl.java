package com.academy.course.liquibase.dao.task;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Student;
import com.academy.course.liquibase.model.Task;
import com.academy.course.liquibase.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import java.sql.SQLException;

public class TaskDAOImpl extends DAOImpl<Task> implements TaskDAO {

    private static final Logger log = LogManager.getLogger(TaskDAOImpl.class);
    private EntityManager em = HibernateUtil.getEntityManager();

    @Override
    public Task save(Task task) throws SQLException {
        try {
            em.getTransaction().begin();
            em.persist(task);
            em.getTransaction().commit();
            em.close();
        }catch (HibernateException e) {
            log.error("erorr");
        }
        return task;
    }
}
