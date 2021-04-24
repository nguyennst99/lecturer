package com.api.lecturerscheduling.service.impl;

import com.api.lecturerscheduling.dto.ClassSubjectDTO;
import com.api.lecturerscheduling.dto.SlotSubjectDTO;
import com.api.lecturerscheduling.dto.SubjectDTO;
import com.api.lecturerscheduling.mapper.ClassSubjectMapper;
import com.api.lecturerscheduling.service.ClassSubjectService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassSubjectServiceImpl implements ClassSubjectService {
    private final ClassSubjectMapper classSubjectMapper;

    public ClassSubjectServiceImpl(ClassSubjectMapper classSubjectMapper) {
        this.classSubjectMapper = classSubjectMapper;
    }

    @Override
    public List<ClassSubjectDTO> getClassSubject(List<SubjectDTO> subjectDTOList) {

        List<ClassSubjectDTO> classSubjectDTOList = new ArrayList<>();

        for (int i = 0; i < subjectDTOList.size(); i++) {
            List<ClassSubjectDTO> classSubjectDTOList1 = classSubjectMapper.getClassSubjectInfo(subjectDTOList.get(i).getSubjectId());
            classSubjectDTOList.addAll(classSubjectDTOList1);
        }
        return classSubjectDTOList;
    }

    @Override
    public String classSubjectId(String subjectId, String classId) {
        return classSubjectMapper.getClassSubjectId(subjectId, classId);
    }


    @Override
    public List<SlotSubjectDTO> getSlotSubject(String classId) {
        return classSubjectMapper.getSlotSubjectDTOList(classId);
    }

    @Override
    public boolean updateStatusClassSubject(String classId, String subjectId) {
        if(classSubjectMapper.updateStatus(classId, subjectId) != 0) {
            return true;
        }
        return false;
    }
}
