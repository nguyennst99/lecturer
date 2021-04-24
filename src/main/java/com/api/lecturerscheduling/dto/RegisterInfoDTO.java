package com.api.lecturerscheduling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterInfoDTO {
    private String classSubjectId;
    private String classId;
    private List<SlotSubjectDTO> slotSubjectDTOList;
}
