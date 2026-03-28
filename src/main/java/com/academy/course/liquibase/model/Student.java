package com.academy.course.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student extends DataEntity implements Serializable {
    @Column
    private String studentName;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "student_tasks",
    joinColumns = {@JoinColumn(name = "task_id")},
    inverseJoinColumns = {@JoinColumn(name = "student_id")})
    private Set<Task> tasks = new HashSet<>();


    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();
}
