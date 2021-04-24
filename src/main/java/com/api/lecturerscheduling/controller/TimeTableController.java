package com.api.lecturerscheduling.controller;

import com.api.lecturerscheduling.dto.*;
import com.api.lecturerscheduling.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "TimeTable", description = "TimeTable API")
public class TimeTableController {

    private final TimeTableService timeTableService;
    private final CourseService courseService;
    private final ClassTimeTableService classTimeTableService;
    private final ClassSubjectService classSubjectService;
    private final SlotService slotService;
    private final CourseUserService courseUserService;

    public TimeTableController(TimeTableService timeTableService, CourseService courseService, ClassTimeTableService classTimeTableService, ClassSubjectService classSubjectService, SlotService slotService, CourseUserService courseUserService) {
        this.timeTableService = timeTableService;
        this.courseService = courseService;
        this.classTimeTableService = classTimeTableService;
        this.classSubjectService = classSubjectService;
        this.slotService = slotService;
        this.courseUserService = courseUserService;
    }

    @Operation(summary = "Get all teaching time table of user", description = "Get all teaching time table of user", tags = { "TimeTable" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found") })
    @GetMapping("/get-time-table")
    public List<TimeTableSubDTO> getTimeTable(@Param("userId") String userId,
                                              @Param("dateFrom") String dateFrom,
                                              @Param("dateTo") String dateTo,
                                              @Param("semester") String semester) {
       return timeTableService.getTimeTableInfo(userId, dateFrom, dateTo, semester);
    }

    @Operation(summary = "Create new time table", description = "Create new time table", tags = { "TimeTable" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "There aren't notification") })
    @PostMapping("/create-class-timetable")
    public boolean createClassTimeTable(@RequestBody ClassTimeTableInfoCreateDTO dto) {
        boolean result = false;
        TimeTableCreateDTO timeTableCreateDTO = new TimeTableCreateDTO();
        ClassTimeTableDTO classTimeTableDTO = new ClassTimeTableDTO();
        String classId = dto.getClassId();
        String userId = dto.getUserId();
        List<SubjectInfoCreateDTO> subjectInfoCreateDTOList = dto.getSubjectList();
        for (int i = 0; i < subjectInfoCreateDTOList.size(); i++) {
            String subject = subjectInfoCreateDTOList.get(i).getSubject();

            int courseId = courseService.courseId(subject);
            String courseUserId = courseUserService.courseUserId(courseId);
            String classSubjectId = classSubjectService.classSubjectId(subject, classId);

            classTimeTableDTO.setClassSubjectId(classSubjectId);
            classTimeTableDTO.setCourseUserId(courseUserId);

            String slot = subjectInfoCreateDTOList.get(i).getSlot();
            String day = subjectInfoCreateDTOList.get(i).getDay();
            String slotID = slotService.getSlotId(slot, day);

            if(timeTableService.getSlotId(userId, slotID) == null) {
                if(classTimeTableService.createClassTimeTable(classTimeTableDTO)) {

                    int classTimeTableIdMax = classTimeTableService.getClassTimeTableIdMax();
                    int weekId = 1;
                    int slotId = Integer.parseInt(slotID);
                    Random rand = new Random();
                    int roomId = rand.nextInt(30) + 1;
                    for (int k = 0; k < 3; k++) {
                        for (int j = 0; j < 10; j++) {
                            if(weekId > 10) {
                                weekId = weekId % 10;
                            }
                            timeTableCreateDTO.setClassTimeTableId(classTimeTableIdMax);
                            timeTableCreateDTO.setSlotId(slotId);
                            timeTableCreateDTO.setWeekId(weekId);
                            timeTableCreateDTO.setRoomId(roomId);
                            if(timeTableService.createTimeTable(timeTableCreateDTO)) {
                                weekId++;
                            }
                        }
                        slotId++;
                    }
                    classSubjectService.updateStatusClassSubject(classId, subject);
                    result = true;
                }
            }
        }
        return result;
    }

    @Operation(summary = "Get All Time Table For Admin", description = "Get All Time Table For Admin", tags = { "TimeTable" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "There aren't notification") })
    @GetMapping("/get-time-table-lecturer")
    public List<TimeTableInfoAdminDTO> getTimeTable(@Param("userId") String userId) {
        return timeTableService.getTimeTableForAdmin(userId);
    }

    @Operation(summary = "Update status of time table", description = "Update status of time table to approve, reject", tags = { "TimeTable" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "There aren't notification") })
    @GetMapping("/update-status-timetable")
    public boolean upStatus(@Param("statusId") String statusId,
                            @Param("timeTableId") int timeTableId) {
        if(timeTableService.updStatus(statusId, timeTableId)) {
            return true;
        }
        return false;
    }
}
