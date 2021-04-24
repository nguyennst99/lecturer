package com.api.lecturerscheduling.mapper;

import com.api.lecturerscheduling.dto.SubjectDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SubjectMapper {
    /**
     * Select subject information
     * @param subjectId
     * @return SubjectDTO
     */
    @Select("SELECT " +
            "   id AS subjectId, " +
            "   subject_name AS subjectName, " +
            "   total_slot AS totalSlot " +
            "FROM " +
            "   public.subject " +
            "WHERE " +
            "   id = #{subject_id}")
    SubjectDTO getSubjectInfo(@Param("subject_id") String subjectId);
}
