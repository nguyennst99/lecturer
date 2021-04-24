package com.api.lecturerscheduling.service.impl;

import com.api.lecturerscheduling.dto.CourseUserDTO;
import com.api.lecturerscheduling.mapper.CourseUserMapper;
import com.api.lecturerscheduling.service.CourseUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseUserServiceImpl implements CourseUserService {

    private final CourseUserMapper userMapper;

    public CourseUserServiceImpl(CourseUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<CourseUserDTO> getAllCourseUser(String userId) {
        return userMapper.getCourseUserInfo(userId);
    }

    @Override
    public String courseUserId(int courseId) {
        return userMapper.getCourseUserId(courseId);
    }

}
