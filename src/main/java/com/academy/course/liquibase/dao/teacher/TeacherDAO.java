package com.academy.course.liquibase.dao.teacher;

import com.academy.course.liquibase.dao.DAO;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;

public interface TeacherDAO extends DAO<Teacher> {
    void addCourse(Course course);
    Course getCourseByTeacherId(Integer id);
    void updateCourseByTeacherId(Course course,Integer teacherId);
}
