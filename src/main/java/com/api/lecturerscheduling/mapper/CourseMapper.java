package com.api.lecturerscheduling.mapper;

import com.api.lecturerscheduling.dto.CourseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CourseMapper {
    /**
     * Select course information
     * @param course_id
     * @return CourseDTO
     */
    @Select("SELECT " +
            "   id AS courseId, " +
            "   semester_id AS semesterId, " +
            "   major_id AS majorId, " +
            "   subject_id AS subjectId, " +
            "   status_id AS statusId " +
            "FROM " +
            "   public.course " +
            "WHERE " +
            "   id = #{course_id} and status_id = '1'")
    CourseDTO getCourseInfo(@Param("course_id") int course_id);


    /**
     * Select courseId
     * @param subject_id
     * @return CourseDTO
     */
    @Select("SELECT " +
            "   id AS courseId " +
            "FROM " +
            "   public.course " +
            "WHERE " +
            "   subject_id = #{subject_id} and status_id = '1'")
    int getCourseId(@Param("subject_id") String subject_id);
}
