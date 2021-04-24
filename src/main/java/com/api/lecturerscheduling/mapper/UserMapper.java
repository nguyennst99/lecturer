package com.api.lecturerscheduling.mapper;

import com.api.lecturerscheduling.dto.UserDTO;
import com.api.lecturerscheduling.dto.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    /**
     * Select user information
     * @param user_id
     * @param uid
     * @return UserDTO
     */
    @Select("SELECT " +
            "   id AS username, " +
            "   uid, " +
            "   role_id AS roleId, " +
            "   status_id AS statusId, " +
            "   full_name AS fullName, " +
            "   point, " +
            "   phone, " +
            "   email " +
            "FROM " +
            "   public.user " +
            "WHERE " +
            "   id = #{user_id} and uid = #{uid} and status_id = '1'")
    UserDTO loginUser(@Param("user_id") String user_id,
                      @Param("uid") String uid);

    /**
     * Select all user
     * @param
     * @param
     * @return UserDTO
     */
    @Select("SELECT " +
            "   id AS userId, " +
            "   full_name AS fullName, " +
            "   point  " +
            "FROM " +
            "   public.user " +
            "WHERE " +
            "   role_id = '1' " )
    List<UserInfoDTO> getAllUser();


    /**
     * Select roleId
     * @param
     * @param
     * @return UserDTO
     */
    @Select("SELECT " +
            "   role_id AS roleId " +
            "FROM " +
            "   public.user " +
            "WHERE " +
            "   id = #{user_id} " )
    String getRoleId(@Param("user_id") String userId);

}
