package com.api.lecturerscheduling.mapper;

import com.api.lecturerscheduling.dto.CourseUserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseUserMapper {
    /**
     * Select course user information
     * @param user_id
     * @return CourseUserDTO
     */
    @Select("SELECT " +
            "   id AS courseUserId, " +
            "   user_id AS userId, " +
            "   course_id AS courseId " +
            "FROM " +
            "   public.course_user " +
            "WHERE " +
            "   user_id = #{user_id}")
    List<CourseUserDTO> getCourseUserInfo(@Param("user_id") String user_id);

    /**
     * Select courseUser_id
     * @param course_id
     * @return CourseUserDTO
     */
    @Select("SELECT " +
            "   id AS courseUserId " +
            "FROM " +
            "   public.course_user " +
            "WHERE " +
            "   course_id = #{course_id}")
    String getCourseUserId(@Param("course_id") int course_id);
}
