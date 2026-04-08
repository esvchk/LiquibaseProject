
package com.academy.course.liquibase.dao.course;
import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.model.Course;
import com.academy.course.liquibase.model.Task;
import com.academy.course.liquibase.model.Teacher;

import javax.persistence.EntityManager;
import java.util.Set;

public class CourseDAOImpl extends DAOImpl<Course> implements CourseDAO {

    public CourseDAOImpl(EntityManager em) {
        super(em, Course.class);
    }
    @Override
    public void addTask(Course course, Task task){
        super.getEm().getTransaction().begin();
        task.setCourse(course);
        super.getEm().getTransaction().commit();
    }
}
