package com.api.lecturerscheduling.controller;

import com.api.lecturerscheduling.dto.*;
import com.api.lecturerscheduling.service.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Subject", description = "Subject API")
public class SubjectController {
    private final CourseUserService courseUserService;
    private final CourseService courseService;
    private final SubjectService subjectService;
    private final ClassSubjectService classSubjectService;
    private final SlotService slotService;

    public SubjectController(CourseUserService courseUserService, CourseService courseService, SubjectService subjectService, ClassSubjectService classSubjectService, SlotService slotService) {
        this.courseUserService = courseUserService;
        this.courseService = courseService;
        this.subjectService = subjectService;
        this.classSubjectService = classSubjectService;
        this.slotService = slotService;
    }

    @Operation(summary = "Get all info class of subject by user", description = "Get all info class of subject by user", tags = { "Subject" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found") })
    @GetMapping("/subject-info")
    public SubjectInfoDTO getSubjectInfo(String userId) {

        List<CourseUserDTO> courseUserDTOList = courseUserService.getAllCourseUser(userId);

        List<CourseDTO> courseDTOList = Optional.ofNullable(courseUserDTOList)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(item -> {
                    CourseDTO courseDTO = courseService.getCourseInfo(item.getCourseId());
                    return courseDTO;
                })
                .collect(Collectors.toList());

        List<SubjectDTO> subjectDTOList = Optional.ofNullable(courseDTOList)
                .orElse(Collections.emptyList())
                .stream()
                .filter(Objects::nonNull)
                .map(item -> {
                    SubjectDTO subjectDTO = subjectService.getSubject(item.getSubjectId());
                    return subjectDTO;
                })
                .collect(Collectors.toList());

        List<ClassSubjectDTO> classSubjectDTOList = classSubjectService.getClassSubject(subjectDTOList);

        List<RegisterDTO> registerInfoDTOList = new ArrayList<>();

        ArrayList<String> arrTemp = new ArrayList<>();
        for (int i = 0; i < classSubjectDTOList.size(); i++) {
            String classSubjectIdRegis = classSubjectDTOList.get(i).getClassSubjectId();
            String classIdRegis = classSubjectDTOList.get(i).getClassId();
            if(arrTemp.stream().filter(u -> u.equalsIgnoreCase(classIdRegis)).findAny().isPresent()) continue;
            arrTemp.add(classIdRegis);
            List<SlotSubjectDTO> slotSubjectDTOList = classSubjectService.getSlotSubject(classSubjectDTOList.get(i).getClassId());
            List<SlotSubjectInfoDTO> slotSubjectInfoDTOList = new ArrayList<>();

            for (int j = 0; j < slotSubjectDTOList.size(); j++) {
                String subject = slotSubjectDTOList.get(j).getSubjectId();
                SlotDTO dto = slotService.getSlotInfo(slotSubjectDTOList.get(j).getSlotId());

                SlotSubjectInfoDTO slotSubjectInfoDTO = new SlotSubjectInfoDTO();
                slotSubjectInfoDTO.setSubject(subject);
                slotSubjectInfoDTO.setSlotDTO(dto);
                slotSubjectInfoDTOList.add(slotSubjectInfoDTO);
            }

            RegisterDTO dto = new RegisterDTO();
            dto.setClassSubjectId(classSubjectIdRegis);
            dto.setClassId(classIdRegis);
            dto.setSlotSubjectInfoDTOList(slotSubjectInfoDTOList);
            registerInfoDTOList.add(dto);
        }

        SubjectInfoDTO subjectInfoDTO = new SubjectInfoDTO();

        subjectInfoDTO.setRegisterDTOList(registerInfoDTOList);

        return subjectInfoDTO;
    }
}