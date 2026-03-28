package com.academy.course.liquibase;

import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Student;
import com.academy.course.liquibase.model.Task;
import com.academy.course.liquibase.model.Teacher;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

public class LiquibaseApp {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();
        Teacher teacher = new Teacher("Sam",null,null);
        Set<Student> studentSet = new HashSet<>();
        Course course = new Course("Math",studentSet,teacher);
        Set<Course> courses = new HashSet<>();
        courses.add(course);
        Task task = new Task("Math","good","@#$",studentSet,teacher);
        Set<Task> tasks = new HashSet<>();
        Student student = new Student("Bob",tasks,courses);
        studentSet.add(student);
        tasks.add(task);

        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();

    }
}
