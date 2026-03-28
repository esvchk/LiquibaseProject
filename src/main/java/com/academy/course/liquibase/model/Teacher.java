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
public class Teacher extends DataEntity implements Serializable {

    @Column
    private String name;

    @OneToOne(mappedBy = "teacher")
    private Course course;

    @OneToMany(mappedBy = "teacher")
    private Set<Task> tasks = new HashSet<>();

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
        return "Teacher{" +
                "name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
