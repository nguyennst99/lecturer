package com.api.lecturerscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassTimeTableDTO {
    private String classSubjectId;
    private String courseUserId;
}
