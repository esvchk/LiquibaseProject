package com.academy.course.liquibase.dao.student;

import com.academy.course.liquibase.dao.DAO;
import com.academy.course.liquibase.model.Answer;
import com.academy.course.liquibase.model.Student;

public interface StudentDAO extends DAO<Student> {
    void addAnswer(Student student, Answer answer);
}
