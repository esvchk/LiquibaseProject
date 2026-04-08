package com.academy.course.liquibase.dao.teacher;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;

import javax.persistence.EntityManager;
import java.util.Set;

public class TeacherDAOImpl extends DAOImpl<Teacher> implements TeacherDAO {
    public TeacherDAOImpl(EntityManager em) {
        super(em, Teacher.class);

    }

    @Override
    public void addCourse(Teacher teacher, Course course) {
        super.getEm().getTransaction().begin();
        teacher.addCourse(course);
        super.getEm().getTransaction().commit();

    }

    @Override
    public Set<Course> getCourses(Teacher teacher) {
        teacher = this.get(teacher.getId());
        return teacher.getCourses();
    }

    @Override
    public void removeCourse(Teacher teacher, Course course) {
        super.getEm().getTransaction().begin();
        teacher.getCourses().remove(course);
        super.getEm().getTransaction().commit();
    }
}
