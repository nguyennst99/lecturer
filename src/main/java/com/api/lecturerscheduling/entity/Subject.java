package com.api.lecturerscheduling.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "subject")
@Entity
@Data
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "total_slot")
    private Integer totalSlot;

}
