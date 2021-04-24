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
public class RegisterDTO {
    private String classSubjectId;
    private String classId;
    private List<SlotSubjectInfoDTO> slotSubjectInfoDTOList;
}
