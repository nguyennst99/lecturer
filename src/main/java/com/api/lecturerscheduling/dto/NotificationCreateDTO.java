package com.api.lecturerscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationCreateDTO implements Serializable {
    private String userId;
    private String title;
    private String content;
    private String time;
    private String statusId;
}
