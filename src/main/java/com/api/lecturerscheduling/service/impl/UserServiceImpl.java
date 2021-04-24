package com.api.lecturerscheduling.service.impl;

import com.api.lecturerscheduling.dto.UserDTO;
import com.api.lecturerscheduling.dto.UserInfoDTO;
import com.api.lecturerscheduling.mapper.UserMapper;
import com.api.lecturerscheduling.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO login(UserDTO dto){
        String username = dto.getUsername();
        String uid = dto.getUid();
        UserDTO userDTO = userMapper.loginUser(username, uid);
        return userDTO;
    }

    @Override
    public List<UserInfoDTO> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public String getRoleId(String userId) {
        return userMapper.getRoleId(userId);
    }

}
