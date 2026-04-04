package com.academy.course.liquibase;

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

        Teacher teacher = new Teacher("Sam",null);
        Student student = new Student("Bob",courses);
        Course course = new Course("Math",students,teacher,tasks);
        Task task = new Task("Math",null,course);
        Mark mark = new Mark(2,"@#$",null);
        Answer answer = new Answer("@#$",task,mark);
        courses.add(course);
        students.add(student);
        tasks.add(task);


        em.getTransaction().begin();
        em.persist(teacher);
        em.persist(course);
        em.getTransaction().commit();

        em.close();
//        Query query = em.createQuery("From Student std where std.studentName like :name order by std.studentName desc");
//        query.setParameter("name","Bill%").getResultList().forEach(System.out::println);

    }
}
