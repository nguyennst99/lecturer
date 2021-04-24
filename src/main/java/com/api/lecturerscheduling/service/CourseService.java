package com.api.lecturerscheduling.service;

import com.api.lecturerscheduling.dto.CourseDTO;

public interface CourseService {
    CourseDTO getCourseInfo(int courseId);
    int courseId(String subject_id);
}
