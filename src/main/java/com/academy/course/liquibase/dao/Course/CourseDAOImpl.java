package com.academy.course.liquibase.dao.Course;


import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;

import javax.persistence.EntityManager;
import java.util.Set;

public class CourseDAOImpl extends DAOImpl<Course> implements CourseDAO {

    private EntityManager entityManager;
    private Course course;

    public CourseDAOImpl(EntityManager entityManager, Course course) {
        this.entityManager = entityManager;
        this.course = course;
    }

    @Override
    public void addTeacher(Teacher teacher) {
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
    }

    @Override
    public Teacher getTeacherByCourseId(Integer id){
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class,id);
        return course1.getTeacher();
    }

    @Override
    public void updateTeacherByCourseId(Teacher teacher, Integer courseId) {
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class,courseId);
        course1.setTeacher(teacher);
        teacher = course1.getTeacher();
        entityManager.flush();
        entityManager.refresh(teacher);
        entityManager.getTransaction().commit();
    }


}
