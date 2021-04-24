package com.api.lecturerscheduling.service;

import com.api.lecturerscheduling.dto.ClassTimeTableDTO;

public interface ClassTimeTableService {
    public boolean createClassTimeTable(ClassTimeTableDTO classTimeTableDTO);
    public int getClassTimeTableIdMax();
}
