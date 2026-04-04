package com.academy.course.liquibase.dao.teacher;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;

import javax.persistence.EntityManager;
import java.util.Set;

public class TeacherDAOImpl extends DAOImpl<Teacher> implements TeacherDAO {
    private EntityManager entityManager;
    private Teacher teacher;

    public TeacherDAOImpl(EntityManager entityManager, Teacher teacher) {
        this.entityManager = entityManager;
        this.teacher = teacher;
    }

    @Override
    public void addCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
    }

    @Override
    public Course getCourseByTeacherId(Integer id) {
        entityManager.getTransaction().begin();
        Teacher teacher1 = entityManager.find(Teacher.class,id);
        entityManager.getTransaction().commit();
        return teacher1.getCourse();
    }

    @Override
    public void updateCourseByTeacherId(Course course, Integer teacherId) {
        entityManager.getTransaction().begin();
        Teacher teacher1 = entityManager.find(Teacher.class,teacherId);
        course = teacher1.getCourse();
        entityManager.merge(course);
        entityManager.getTransaction().commit();
    }
}
