package com.api.lecturerscheduling.service;

import com.api.lecturerscheduling.dto.UserDTO;
import com.api.lecturerscheduling.dto.UserInfoDTO;

import java.util.List;

public interface UserService {
    UserDTO login(UserDTO dto);
    List<UserInfoDTO> getAllUser();
    String getRoleId(String userId);
}
