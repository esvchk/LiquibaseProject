package com.academy.course.liquibase;

import com.academy.course.liquibase.dao.CourseDAO;
import com.academy.course.liquibase.dao.CourseDAOImpl;
import com.academy.course.liquibase.model.*;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.security.CodeSource;
import java.util.HashSet;
import java.util.Set;

public class LiquibaseApp {
    public static void main(String[] args) {
        Teacher teacher = Teacher.builder().name("TeacherName!").build();
        Course course = Course.builder().courseName("courseName!").build();
        Student student = Student.builder().studentName("studentName!").build();
        Set<Student> set = new HashSet<>();
        set.add(student);
        course.setTeacher(teacher);
        course.setStudents(set);
        CourseDAO courseDAO = new CourseDAOImpl();
        courseDAO.save(course);

    }
}
