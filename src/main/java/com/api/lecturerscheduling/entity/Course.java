package com.api.lecturerscheduling.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "semester_id")
    private String semesterId;

    @Column(name = "major_id")
    private String majorId;

    @Column(name = "subject_id")
    private String subjectId;

    @Column(name = "status_id")
    private String statusId;

}
