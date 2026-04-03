package com.academy.course.liquibase.dao.teacher;

import com.academy.course.liquibase.dao.DAO;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;

import java.util.Set;

public interface TeacherDAO extends DAO<Teacher> {

    void addCourse(Course course);

    Set<Course> getCourses();
}
