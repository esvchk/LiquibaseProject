package com.academy.course.liquibase.dao.student;

import com.academy.course.liquibase.dao.DAO;
import com.academy.course.liquibase.model.Answer;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Student;
import com.academy.course.liquibase.model.Task;

import java.util.Set;

public interface StudentDAO extends DAO<Student> {

    void addCourse(Student student, Course course);

    Set<Course> getCourses(Student student);

    void removeCourse(Student student, Course course);

    void addAnswer(Student student, Answer answer);

    Set<Answer> getAnswers(Student student);

    void removeAnswer(Student student, Task task);
}
