package com.academy.course.liquibase.model;

import java.io.Serializable;

public class CompositePK implements Serializable {

    private Integer student;

    private Integer task;

    public CompositePK(Integer student, Integer task) {
        this.student = student;
        this.task = task;
    }
}
