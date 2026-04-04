package com.academy.course.liquibase.dao.teacher;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;
import com.academy.course.liquibase.utils.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Optional;
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
        teacher = entityManager.merge(teacher);
        course = entityManager.merge(course);
        teacher.getCourses().add(course);
        course.getTeachers().add(teacher);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Set<Course> getCourses() {
        entityManager.getTransaction().begin();
        Teacher teacher1 = entityManager.find(Teacher.class,teacher.getId());
        return teacher1.getCourses();
    }
}
