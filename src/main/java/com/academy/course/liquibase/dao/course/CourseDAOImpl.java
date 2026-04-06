
package com.academy.course.liquibase.dao.course;
import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Teacher;

import javax.persistence.EntityManager;
import java.util.Set;

public class CourseDAOImpl extends DAOImpl<Course> implements CourseDAO {

    public CourseDAOImpl(EntityManager em) {
        super(em, Course.class);
    }

    @Override
    public void addTeacher(Course course,Teacher teacher) {
        super.getEm().getTransaction().begin();
        course = super.getEm().merge(course);
        teacher = super.getEm().merge(teacher);
        course.getTeachers().add(teacher);
        teacher.getCourses().add(course);
        super.getEm().getTransaction().commit();
    }

    @Override
    public Set<Teacher> getTeachers(Course course){
        super.getEm().getTransaction().begin();
        Course course1 = super.getEm().find(Course.class,course.getId());
        super.getEm().getTransaction().commit();
        return course1.getTeachers();
    }
}
