package com.academy.course.liquibase.dao.answer;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Answer;

import javax.persistence.EntityManager;

public class AnswerDAOImpl extends DAOImpl<Answer> implements AnswerDAO {
    public AnswerDAOImpl(EntityManager em) {
        super(em, Answer.class);
    }
}
