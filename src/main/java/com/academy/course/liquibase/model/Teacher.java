package com.academy.course.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table
@SuperBuilder
public class Teacher extends DataEntity implements Serializable {
    public Teacher(String name) {
        this.name = name;
    }

    @Column
    private String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "teachers_courses",
    joinColumns = {@JoinColumn(name = "teacher_id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> courses = new HashSet<>();


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getId(),teacher.getId());
    }


    @Override
    public int hashCode() {
        return 15;
    }

    @Override
    public String toString() {
        return "Teacher{ name= name}";
    }
}
