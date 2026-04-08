package com.academy.course.liquibase;


import com.academy.course.liquibase.dao.course.CourseDAO;
import com.academy.course.liquibase.dao.course.CourseDAOImpl;
import com.academy.course.liquibase.dao.student.StudentDAO;
import com.academy.course.liquibase.dao.student.StudentDAOImpl;
import com.academy.course.liquibase.dao.task.TaskDAO;
import com.academy.course.liquibase.dao.task.TaskDAOImpl;
import com.academy.course.liquibase.dao.teacher.TeacherDAO;
import com.academy.course.liquibase.dao.teacher.TeacherDAOImpl;
import com.academy.course.liquibase.model.*;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;

public class LiquibaseApp {
    public static void main(String[] args) {
        Course course = new Course("courseName",null,null,null);
        Task task = new Task("taskName",course, null);
        Student student = new Student("studentName");
        Answer answer = new Answer("answer",student,task,10,"feedback");
        student.getAnswers().add(answer);
        answer.setStudent(student);
        EntityManager em = HibernateUtil.getEntityManager();
        StudentDAO studentDAO = new StudentDAOImpl(em);
        TaskDAO taskDAO = new TaskDAOImpl(em);
        CourseDAO courseDAO = new CourseDAOImpl(em);
        courseDAO.save(course);
        taskDAO.save(task);
        studentDAO.save(student);
    }
}
