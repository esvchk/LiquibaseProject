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


        Teacher teacher = new Teacher("Sam", null);
        Student student = new Student("Bob", null);
        students.add(student);
        Mark mark = new Mark(2, "@#$", null);
        Answer answer = new Answer("@#$", null, null);
        Task task = new Task("Math", "good", "@#$", null, null);
        tasks.add(task);
        Course course = new Course("Math", students, null, null);

        course.setTeacher(teacher);
        course.setTasks(tasks);

        task.setCourse(course);

        answer.setTask(task);
        task.setAnswer(answer);
        mark.setAnswer(answer);
        answer.setMark(mark);
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();

//        Query query = em.createQuery("From Student std where std.studentName like :name order by std.studentName desc");
//        query.setParameter("name","Bill%").getResultList().forEach(System.out::println);

    }
}
