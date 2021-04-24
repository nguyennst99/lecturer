package com.api.lecturerscheduling.service.impl;

import com.api.lecturerscheduling.dto.ClassTimeTableDTO;
import com.api.lecturerscheduling.mapper.ClassTimeTableMapper;
import com.api.lecturerscheduling.service.ClassTimeTableService;
import org.springframework.stereotype.Service;

@Service
public class ClassTimeTableServiceImpl implements ClassTimeTableService {
    private final ClassTimeTableMapper classTimeTableMapper;

    public ClassTimeTableServiceImpl(ClassTimeTableMapper classTimeTableMapper) {
        this.classTimeTableMapper = classTimeTableMapper;
    }

    @Override
    public boolean createClassTimeTable(ClassTimeTableDTO classTimeTableDTO) {
        if(classTimeTableMapper.insClassTimeTable(classTimeTableDTO) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getClassTimeTableIdMax() {
        return classTimeTableMapper.getClassTimeTableMax();
    }
}
