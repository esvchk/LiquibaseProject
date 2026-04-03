package com.academy.course.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@SuperBuilder
public class Teacher extends DataEntity implements Serializable {

    @Column
    private String name;

    @ManyToMany
    @JoinTable(name = "teachers_courses",
    joinColumns = {@JoinColumn(name = "teacher_id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private Set<Course> courses;


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getId(),teacher.getId());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Teacher{ name= name}";
    }
}
