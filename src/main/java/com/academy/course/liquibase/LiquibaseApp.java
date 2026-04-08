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

        Course course = new Course("CourseName");
        Course course1 = new Course("CourseName1");
        Task task = new Task("taskName", course, null);
        Teacher teacher = new Teacher("TeacherName");
        teacher.getCourses().add(course);
        task.setCourse(course);


        Student student = new Student("studentName");
        student.getCourses().add(course);
        course.getStudents().add(student);
        course.getTasks().add(task);
        Answer answer = new Answer("studentAnswer", student, task, 10, "feedback");
        student.getAnswers().add(answer);


        TeacherDAO teacherDAO = new TeacherDAOImpl(em);
        StudentDAO studentDAO = new StudentDAOImpl(em);
        AnswerDAO answerDAO = new AnswerDAOImpl(em);

        studentDAO.save(student);
        teacherDAO.save(teacher);
        answerDAO.save(answer);

    }
}
