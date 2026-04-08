package com.academy.course.liquibase;


import com.academy.course.liquibase.dao.answer.AnswerDAO;
import com.academy.course.liquibase.dao.answer.AnswerDAOImpl;
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
        EntityManager em = HibernateUtil.getEntityManager();

  /*      Teacher teacher = new Teacher("TeacherName");
        Course course = new Course("CourseName");
        Task task = new Task("taskName");
        Student student = new Student("studentName");
        Answer answer = new Answer("studentAnswer",10,"feedback");
        teacher.addCourse(course);
        course.addTask(task);
        task.addAnswer(answer);
        student.addCourse(course);
        student.addAnswer(answer);*/


        TeacherDAO teacherDAO = new TeacherDAOImpl(em);
        StudentDAO studentDAO = new StudentDAOImpl(em);
        AnswerDAO answerDAO = new AnswerDAOImpl(em);

        Teacher teacher = teacherDAO.get(2);
        teacher.getCourses().add(new Course());
        teacher.getCourses().add(new Course());
        teacher.getCourses().add(new Course("name"));
        teacher.getCourses().add(new Course(" "));
        System.out.println(teacher.getCourses());
        System.out.println(teacherDAO.getCourses(teacher));

    }
}
