package com.academy.course.liquibase;

import com.academy.course.liquibase.dao.Course.CourseDAO;
import com.academy.course.liquibase.dao.Course.CourseDAOImpl;
import com.academy.course.liquibase.dao.teacher.TeacherDAO;
import com.academy.course.liquibase.dao.teacher.TeacherDAOImpl;
import com.academy.course.liquibase.model.*;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class LiquibaseApp {
    public static void main(String[] args) {

        EntityManager em = HibernateUtil.getEntityManager();

        Set<Student> students = new HashSet<>();
        Set<Course> courses = new HashSet<>();
        Set<Task> tasks = new HashSet<>();

        Teacher teacher = new Teacher("Bob",null);
        Student student = new Student("Morty",courses,null);
        Student student2 = new Student("Rick",courses,null);
        Course course = new Course("History",students,teacher,tasks);
        Task task = new Task("Math",course);
        Task task2 = new Task("Math",course);
        Mark mark = new Mark(2,"@#$",null);
        Answer answer = new Answer("@#$",task,student);
        Answer answer2 = new Answer("@#$",task2,student2);
        students.add(student);
        students.add(student2);
        courses.add(course);
        tasks.add(task);


        CourseDAO courseDAO = new CourseDAOImpl(em);
//        Teacher newTeacher = courseDAO.getTeacherByCourseId(4);
//        courseDAO.addTeacher(teacher);
        TeacherDAO teacherDAO = new TeacherDAOImpl(em,teacher);
//        teacherDAO.addCourse(course);
//        courseDAO.updateTeacherByCourseId(newTeacher,8);
        courseDAO.setStudentOnCourse(students,8);

//        Query query = em.createQuery("From Student std where std.studentName like :name order by std.studentName desc");
//        query.setParameter("name","Bill%").getResultList().forEach(System.out::println);

    }
}
