package com.api.lecturerscheduling.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "class_timetable")
@Data
public class ClassTimetable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "class_subject_id")
    private String classSubjectId;

    @Column(name = "course_user_id")
    private String courseUserId;

}
