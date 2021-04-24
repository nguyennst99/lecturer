package com.api.lecturerscheduling.service.impl;

import com.api.lecturerscheduling.dto.TimeTableCreateDTO;
import com.api.lecturerscheduling.dto.TimeTableInfoAdminDTO;
import com.api.lecturerscheduling.dto.TimeTableSubDTO;
import com.api.lecturerscheduling.mapper.TimeTableMapper;
import com.api.lecturerscheduling.service.TimeTableService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    private final TimeTableMapper timeTableMapper;

    public TimeTableServiceImpl(TimeTableMapper timeTableMapper) {
        this.timeTableMapper = timeTableMapper;
    }

    @Override
    public List<TimeTableSubDTO> getTimeTableInfo(String userId, String dateFrom, String dateTo, String semester) {
        return timeTableMapper.getTimeTableSubInfo(userId, dateFrom, dateTo, semester);
    }

    @Override
    public boolean createTimeTable(TimeTableCreateDTO timeTableCreateDTO) {
        if(timeTableMapper.insTimeTable(timeTableCreateDTO) != 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<TimeTableInfoAdminDTO> getTimeTableForAdmin(String userId) {
        return timeTableMapper.getTimeTableForAdmin(userId);
    }

    @Override
    public boolean updStatus(String statusId, int timeTableId) {
        for (int i = 0; i < 30; i++) {
            if(timeTableMapper.updStatus(statusId, timeTableId) != 0) {
                timeTableId++;
            }
        }
        return true;
    }

    @Override
    public String getSlotId(String userId, String slotId) {
        return timeTableMapper.getSlotId(userId, slotId);
    }
}
