package com.api.lecturerscheduling.service;

import com.api.lecturerscheduling.dto.CourseUserDTO;

import java.util.List;

public interface CourseUserService {
    List<CourseUserDTO> getAllCourseUser(String userId);
    String courseUserId(int courseId);
}
