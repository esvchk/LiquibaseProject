package com.academy.course.liquibase.dao.Course;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;

import javax.persistence.EntityManager;
import java.util.Set;

public class CourseDAOImpl extends DAOImpl<Course> implements CourseDAO{
    private EntityManager entityManager;
    private Course course;
    public CourseDAOImpl(EntityManager entityManager, Course course) {
        this.entityManager = entityManager;
        this.course = course;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        course = entityManager.merge(course);
        teacher = entityManager.merge(teacher);
        course.getTeachers().add(teacher);
        teacher.getCourses().add(course);
        entityManager.getTransaction().commit();
    }

    @Override
    public Set<Teacher> getTeachers(){
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class,course.getId());
        return course1.getTeachers();
    }
}
