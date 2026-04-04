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

        Teacher teacher = new Teacher("Bill",null);
        Student student = new Student("Bob",courses,null);
        Course course = new Course("Math",students,teacher,tasks);
        Task task = new Task("Math",course);
        Mark mark = new Mark(2,"@#$",null);
        Answer answer = new Answer("@#$",task,student);
        courses.add(course);
        students.add(student);
        tasks.add(task);


        CourseDAO courseDAO = new CourseDAOImpl(em,course);
//        courseDAO.addTeacher(teacher);
        TeacherDAO teacherDAO = new TeacherDAOImpl(em,teacher);
//        teacherDAO.addCourse(course);
        System.out.println(teacherDAO.getCourseByTeacherId(4));

//        Query query = em.createQuery("From Student std where std.studentName like :name order by std.studentName desc");
//        query.setParameter("name","Bill%").getResultList().forEach(System.out::println);

    }
}
