package com.academy.course.liquibase.dao.student;

import com.academy.course.liquibase.dao.DAOImpl;
import com.academy.course.liquibase.dao.answer.AnswerDAO;
import com.academy.course.liquibase.dao.answer.AnswerDAOImpl;
import com.academy.course.liquibase.model.*;

import javax.persistence.EntityManager;
import java.util.Set;

public class StudentDAOImpl extends DAOImpl<Student> implements StudentDAO {
    public StudentDAOImpl(EntityManager em) {
        super(em, Student.class);
    }

    @Override
    public void addCourse(Student student, Course course) {
        super.getEm().getTransaction().begin();
        student.getCourses().add(course);
        course.getStudents().add(student);
        super.getEm().getTransaction().commit();
    }

    @Override
    public Set<Course> getCourses(Student student) {
        Student student1 = this.get(student.getId());
        return student1.getCourses();
    }

    public void removeCourse(Student student, Course course) {
        super.getEm().getTransaction().begin();
        student.getCourses().remove(course);
        course.getStudents().remove(student);
        super.getEm().getTransaction().commit();
    }

    @Override
    public void addAnswer(Student student, Answer answer) {
        super.getEm().getTransaction().begin();
        student.addAnswer(answer);
        super.getEm().getTransaction().commit();
    }

    @Override
    public Set<Answer> getAnswers(Student student) {
        Student student1 = this.get(student.getId());
        return student1.getAnswers();
    }

    @Override
    public void removeAnswer(Student student, Task task) {
        AnswerDAO answerDAO = new AnswerDAOImpl(getEm());
        CompositePK pk = new CompositePK(student.getId(), task.getId());
        answerDAO.delete(pk);
    }

}
