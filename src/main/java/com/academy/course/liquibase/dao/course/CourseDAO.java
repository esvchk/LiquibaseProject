package com.academy.course.liquibase.dao.course;

import com.academy.course.liquibase.dao.DAO;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Task;
import com.academy.course.liquibase.model.Teacher;

import java.util.Set;

public interface CourseDAO extends DAO<Course> {

    void addTask(Course course, Task task);

    Set<Task> getTasks(Course course);

    void removeTask(Course course, Task task);

}
