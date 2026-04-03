package com.academy.course.liquibase;

import com.academy.course.liquibase.dao.Course.CourseDAO;
import com.academy.course.liquibase.dao.Course.CourseDAOImpl;
import com.academy.course.liquibase.dao.teacher.TeacherDAO;
import com.academy.course.liquibase.dao.teacher.TeacherDAOImpl;
import com.academy.course.liquibase.model.*;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class LiquibaseApp {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("myName@@@!", new HashSet<>());
        teacher.setId(44);
        Course course = new Course("myName###!", null, new HashSet<>(), null);
        course.setId(36);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        TeacherDAO teacherDAO = new TeacherDAOImpl(entityManager, teacher);
        CourseDAO courseDAO = new CourseDAOImpl(entityManager, course);
        System.out.println(courseDAO.getTeachers());
    }
}
