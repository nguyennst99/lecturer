package com.api.lecturerscheduling.service;

import com.api.lecturerscheduling.dto.SubjectDTO;

public interface SubjectService {
    SubjectDTO getSubject(String subjectId);
}
