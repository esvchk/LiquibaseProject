package com.academy.course.liquibase.dao.answer;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Answer;
import com.academy.course.liquibase.model.CompositePK;
import com.academy.course.liquibase.model.Student;
import com.academy.course.liquibase.model.Task;

import javax.persistence.EntityManager;

public class AnswerDAOImpl extends DAOImpl<Answer> implements AnswerDAO {

    public AnswerDAOImpl(EntityManager em) {
        super(em, Answer.class);
    }

    @Override
    public void addTask(Answer answer, Task task) {
        super.getEm().getTransaction().begin();
        answer.setTask(task);
        task.getAnswers().add(answer);
        super.getEm().getTransaction().commit();
    }

    public Answer getAnswer(Student student, Task task) {
        super.getEm().getTransaction().begin();
        CompositePK pk = new CompositePK(student.getId(), task.getId());
        Answer answer = super.getEm().find(Answer.class, pk);
        super.getEm().getTransaction().commit();
        return answer;
    }
}
