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

     /*   Teacher teacher = new Teacher("TeacherName");
        Course course = new Course("CourseName");
        Course course1 = new Course("CourseName1");
        Course course2 = new Course("CourseName2");
        Answer answer = new Answer("studentAnswer",10,"feedback");
        Student student = new Student("studentName");

        Task task = new Task("taskName");
        Task task1 = new Task("taskName1");
        Task task2 = new Task("taskName2");
        Task task3 = new Task("taskName3");
        Task task4 = new Task("taskName4");

        teacher.addCourse(course);
        teacher.addCourse(course1);
        teacher.addCourse(course2);

        course.addTask(task);
        course.addTask(task1);
        course1.addTask(task2);
        course2.addTask(task3);
        course2.addTask(task4);

        student.addCourse(course1);
        student.addCourse(course2);
        student.addAnswer(answer);
        task.addAnswer(answer);*/

        TeacherDAO teacherDAO = new TeacherDAOImpl(em);
        StudentDAO studentDAO = new StudentDAOImpl(em);
        AnswerDAO answerDAO = new AnswerDAOImpl(em);
        TaskDAO taskDAO = new TaskDAOImpl(em);

        Student student = studentDAO.get(24);
        Task task = taskDAO.get(27);

        studentDAO.removeAnswer(student,task);
    }
}
