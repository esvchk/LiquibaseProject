package com.academy.course.liquibase.dao.task;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Task;

import javax.persistence.EntityManager;

public class TaskDAOImpl extends DAOImpl<Task> implements TaskDAO {

    public TaskDAOImpl(EntityManager em) {

        super(em, Task.class);

    }
}
