package com.academy.course.liquibase.dao.student;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Answer;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Student;

import javax.persistence.EntityManager;

public class StudentDAOImpl extends DAOImpl<Student> implements StudentDAO {
    public StudentDAOImpl(EntityManager em) {
        super(em, Student.class);
    }
    @Override
    public void addAnswer(Student student, Answer answer) {
        super.getEm().getTransaction().begin();
        answer.setStudent(student);
        super.getEm().getTransaction().commit();

    }

}
