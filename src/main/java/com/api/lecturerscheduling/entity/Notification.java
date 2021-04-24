package com.api.lecturerscheduling.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "notification")
@Data
public class Notification {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "time")
    private String time;

    @Column(name = "status_id")
    private String statusId;
}
