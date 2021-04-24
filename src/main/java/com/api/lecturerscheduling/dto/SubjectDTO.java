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
public class SubjectDTO implements Serializable {
    private String subjectId;
    private String subjectName;
    private int totalSlot;

}
