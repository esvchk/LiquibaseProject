package com.academy.course.liquibase;

import com.academy.course.liquibase.dao.course.CourseDAO;
import com.academy.course.liquibase.dao.course.CourseDAOImpl;
import com.academy.course.liquibase.dao.student.StudentDAO;
import com.academy.course.liquibase.dao.student.StudentDAOImpl;
import com.academy.course.liquibase.dao.teacher.TeacherDAO;
import com.academy.course.liquibase.dao.teacher.TeacherDAOImpl;
import com.academy.course.liquibase.model.*;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class LiquibaseApp {
    public static void main(String[] args) throws SQLException {


        EntityManager em = HibernateUtil.getEntityManager();

        Set<Student> students = new HashSet<>();
        Set<Course> courses = new HashSet<>();
        Set<Answer> answers = new HashSet<>();
        Set<Task> tasks = new HashSet<>();


        Teacher teacher = new Teacher("loh",null);
        Student student = new Student("Stifler",courses, answers);
        Course course = new Course("Biology",students,teacher,tasks);
        Task task = new Task("Math",null,course);
        Mark mark = new Mark(2,"@#$",null);
        Answer answer = new Answer("@#$", task, student, mark);



        courses.add(course);
        students.add(student);
        tasks.add(task);
        mark.setAnswer(answer);


//        em.getTransaction().begin();
//        em.persist(teacher);
//        em.persist(course);
//        em.persist(student);
//        em.persist(task);
//        em.persist(mark);
//        em.persist(answer);

        TeacherDAO teacherDAO = new TeacherDAOImpl();
        teacherDAO.save(teacher);
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.save(student);
        CourseDAO courseDAO = new CourseDAOImpl();
        courseDAO.save(course);


//        em.getTransaction().commit();

//        Query query = em.createQuery("From Student std where std.studentName like :name order by std.studentName desc");
//        query.setParameter("name","Bill%").getResultList().forEach(System.out::println);

    }
}
