package com.academy.course.liquibase.dao.answer;

import com.academy.course.liquibase.dao.DAO;
import com.academy.course.liquibase.model.Answer;
import com.academy.course.liquibase.model.Student;
import com.academy.course.liquibase.model.Task;

public interface AnswerDAO extends DAO<Answer>{
    void addTask(Answer answer, Task task);

    Answer getAnswer(Student student, Task task);
}
