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
public class TimeTableSubDTO implements Serializable {
    private String subjectName;
    private String roomName;
    private String slotName;
    private String slotTime;
    private String dateFrom;
    private String dateTo;
    private String semester;
    private String slotDay;
    private String subject;
    private String classId;
}
