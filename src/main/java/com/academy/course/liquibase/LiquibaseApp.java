package com.academy.course.liquibase;

import com.academy.course.liquibase.dao.Course.CourseDAO;
import com.academy.course.liquibase.dao.Course.CourseDAOImpl;
import com.academy.course.liquibase.dao.teacher.TeacherDAO;
import com.academy.course.liquibase.dao.teacher.TeacherDAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.HashSet;

public class LiquibaseApp {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("myName@@@!", new HashSet<>());
        Course course = new Course("myName###1111111!", null, new HashSet<>(), null);
        EntityManager entityManager = HibernateUtil.getEntityManager();
        TeacherDAO teacherDAO = new TeacherDAOImpl(entityManager,teacher);
        teacherDAO.save(teacher);
        CourseDAO courseDAO = new CourseDAOImpl(entityManager, course);
        courseDAO.save(course);
        teacherDAO.addCourse(course);
    }
}
