package com.api.lecturerscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeTableInfoAdminDTO {
    private String slotName;
    private String slotTime;
    private String slotDay;
    private String subjectId;
    private String classId;
    private int timeTableId;
    private String statusId;
}
