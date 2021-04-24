package com.api.lecturerscheduling.service.impl;

import com.api.lecturerscheduling.dto.SubjectDTO;
import com.api.lecturerscheduling.mapper.SubjectMapper;
import com.api.lecturerscheduling.service.SubjectService;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectMapper subjectMapper;

    public SubjectServiceImpl(SubjectMapper subjectMapper) {
        this.subjectMapper = subjectMapper;
    }

    @Override
    public SubjectDTO getSubject(String subjectId) {
        return subjectMapper.getSubjectInfo(subjectId);
    }
}
