package com.academy.course.liquibase;


import com.academy.course.liquibase.dao.course.CourseDAO;
import com.academy.course.liquibase.dao.course.CourseDAOImpl;
import com.academy.course.liquibase.dao.teacher.TeacherDAO;
import com.academy.course.liquibase.dao.teacher.TeacherDAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Task;
import com.academy.course.liquibase.model.Teacher;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;

public class LiquibaseApp {
    public static void main(String[] args) {
        Course course = new Course("name!!");
        Teacher teacher = new Teacher("name!");
        Task task = new Task("name");


        teacher.getCourses().add(course);
        course.getTasks().add(task);
        task.setCourse(course);

        EntityManager em = HibernateUtil.getEntityManager();
        TeacherDAO teacherDAO = new TeacherDAOImpl(em);
        CourseDAO courseDAO = new CourseDAOImpl(em);
        teacherDAO.save(teacher);

    /*    teacherDAO.removeCourse(teacher,course);*/
    }
}
