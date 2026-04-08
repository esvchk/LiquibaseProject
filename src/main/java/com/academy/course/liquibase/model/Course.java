package com.academy.course.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
public class Course extends DataEntity implements Serializable {

    @Column
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @ManyToMany
    @JoinTable(name = "student_courses",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<Student> students = new HashSet<>();

    @ManyToMany(mappedBy = "courses")
    private Set<Teacher> teachers = new HashSet<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.PERSIST)
    private Set<Task> tasks = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        Course course = (Course) o;
        return Objects.equals(getId(), course.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseName());
    }

    @Override
    public String toString() {
        return "Course courseName= " + courseName;
    }
}
