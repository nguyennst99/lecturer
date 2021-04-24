package com.api.lecturerscheduling.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String userId;

    @Column(name = "uid", nullable = false)
    private String uid;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "status_id")
    private String statusId;

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "point")
    private String point;

}
