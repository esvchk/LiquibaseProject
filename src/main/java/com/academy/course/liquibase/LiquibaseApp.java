package com.academy.course.liquibase;

import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Student;
import com.academy.course.liquibase.model.Task;
import com.academy.course.liquibase.model.Teacher;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.HashSet;
import java.util.Set;

public class LiquibaseApp {
    public static void main(String[] args) {

        EntityManager em = HibernateUtil.getEntityManager();

        Teacher teacher = new Teacher("Sam",null);

        Task task = new Task("Math","good","@#$",null,null);
        Set<Task> tasks = new HashSet<>();
        tasks.add(task);

        Course course = new Course("Math",null,teacher,tasks);
        Set<Course> courses = new HashSet<>();
        courses.add(course);

        Student student = new Student("Bob",tasks,courses);
        Set<Student> students = new HashSet<>();
        students.add(student);


        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();

        Query query = em.createQuery("From Student std where std.studentName like :name order by std.studentName desc");
        query.setParameter("name","Bill%").getResultList().forEach(System.out::println);

    }
}
