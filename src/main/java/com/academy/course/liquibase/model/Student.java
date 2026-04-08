package com.academy.course.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@SuperBuilder
public class Student extends DataEntity implements Serializable {

    @Column
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    private Set<Answer> answers = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(),student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", tasks=" +
                ", courses=" + courses +
                '}';
    }
}
