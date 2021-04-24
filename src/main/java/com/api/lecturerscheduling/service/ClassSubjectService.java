package com.api.lecturerscheduling.service;

import com.api.lecturerscheduling.dto.ClassSubjectDTO;
import com.api.lecturerscheduling.dto.SlotSubjectDTO;
import com.api.lecturerscheduling.dto.SubjectDTO;

import java.util.List;

public interface ClassSubjectService {
    List<ClassSubjectDTO> getClassSubject(List<SubjectDTO> subjectDTOList);
    String classSubjectId(String subjectId, String classId);
    List<SlotSubjectDTO> getSlotSubject(String classId);
    boolean updateStatusClassSubject(String classId, String subjectId);
}
