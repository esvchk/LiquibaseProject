package com.academy.course.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Answer implements Serializable {

    public Answer(String studentAnswer, int mark, String feedback) {
        this.studentAnswer = studentAnswer;
        this.mark = mark;
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(studentAnswer, answer.studentAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentAnswer);
    }

    @Column
    private String studentAnswer;

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column
    private int mark;

    @Column
    private String feedback;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updateDateTime;

}
