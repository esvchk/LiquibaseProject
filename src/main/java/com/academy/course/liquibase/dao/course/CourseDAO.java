package com.academy.course.liquibase.dao.course;

import com.academy.course.liquibase.dao.DAO;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;

import java.util.Set;

public interface CourseDAO extends DAO<Course> {

    void addTeacher(Course course, Teacher teacher);

    Set<Teacher> getTeachers(Course course);
}
