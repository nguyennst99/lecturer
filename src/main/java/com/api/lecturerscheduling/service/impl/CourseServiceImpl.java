package com.api.lecturerscheduling.service.impl;

import com.api.lecturerscheduling.dto.CourseDTO;
import com.api.lecturerscheduling.mapper.CourseMapper;
import com.api.lecturerscheduling.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseDTO getCourseInfo(int courseId) {
        return courseMapper.getCourseInfo(courseId);
    }

    @Override
    public int courseId(String subject_id) {
        return courseMapper.getCourseId(subject_id);
    }

}
