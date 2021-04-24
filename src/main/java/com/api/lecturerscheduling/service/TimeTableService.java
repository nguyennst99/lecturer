package com.api.lecturerscheduling.service;

import com.api.lecturerscheduling.dto.TimeTableCreateDTO;
import com.api.lecturerscheduling.dto.TimeTableInfoAdminDTO;
import com.api.lecturerscheduling.dto.TimeTableSubDTO;

import java.util.List;

public interface TimeTableService {
    List<TimeTableSubDTO> getTimeTableInfo(String userId, String dateFrom, String dateTo, String semester);
    boolean createTimeTable(TimeTableCreateDTO timeTableCreateDTO);
    List<TimeTableInfoAdminDTO> getTimeTableForAdmin(String userId);
    boolean updStatus(String statusId, int timeTableId);
    String getSlotId(String userId, String slotId);
}
