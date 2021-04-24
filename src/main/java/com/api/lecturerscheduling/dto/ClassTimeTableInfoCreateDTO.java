package com.api.lecturerscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassTimeTableInfoCreateDTO {
    private String userId;
    private String classId;
    private List<SubjectInfoCreateDTO> subjectList;
}
