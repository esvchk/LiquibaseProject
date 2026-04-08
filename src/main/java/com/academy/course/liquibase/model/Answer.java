package com.academy.course.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Answer implements Serializable {

    public Answer(String studentAnswer, Student student, Task task, int mark, String feedback) {
        this.studentAnswer = studentAnswer;
        this.student = student;
        this.task = task;
        this.mark = mark;
        this.feedback = feedback;
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
