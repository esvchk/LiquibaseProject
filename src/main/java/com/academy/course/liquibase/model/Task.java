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
public class Task extends DataEntity implements Serializable {

    public Task(String name) {
        this.name = name;
    }

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "task")
    private Set<Answer> answers = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        Task task = (Task) o;
        return Objects.equals(getId(),task.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", mark='" +
                ", feedback='" +
                '}';
    }
    public void addAnswer(Answer answer){
        this.getAnswers().add(answer);
        answer.setTask(this);
    }
}
