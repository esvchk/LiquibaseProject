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
public class Mark extends DataEntity implements Serializable {

    @Column
    private Integer mark;

    @Column
    private String feedback;

    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;
}
