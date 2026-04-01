package com.academy.course.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class Student extends DataEntity implements Serializable {

    @Column
    private String studentName;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "student")
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
        return Objects.hash(getId());
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
