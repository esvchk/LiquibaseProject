package com.academy.course.liquibase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Answer extends DataEntity implements Serializable {

    @Column
    private String studentAnswer;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;





}
