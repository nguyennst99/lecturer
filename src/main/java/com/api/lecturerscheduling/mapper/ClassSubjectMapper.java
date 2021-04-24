package com.api.lecturerscheduling.mapper;

import com.api.lecturerscheduling.dto.ClassSubjectDTO;
import com.api.lecturerscheduling.dto.SlotSubjectDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ClassSubjectMapper {
    /**
     * Select class subject information
     *
     * @param subjectId
     * @return ClassSubjectDTO
     */
    @Select("SELECT " +
            "   id AS classSubjectId, " +
            "   class_id AS classId, " +
            "   subject_id AS subjectId " +
            "FROM " +
            "   public.class_subject " +
            "WHERE " +
            "   subject_id = #{subjectId}  AND status_id = '3'  ")
    List<ClassSubjectDTO> getClassSubjectInfo(@Param("subjectId") String subjectId);

    /**
     * Select slot, subject information
     *
     * @param classId
     * @return ClassSubjectDTO
     */
    @Select("SELECT " +
            "   subject_id AS subjectId, " +
            "   slot_id AS slotId " +
            "FROM " +
            "   public.class_subject " +
            "WHERE " +
            "   class_id = #{classId} AND status_id = '3' ")
    List<SlotSubjectDTO> getSlotSubjectDTOList(@Param("classId") String classId);

    /**
     * Select class subject information
     *
     * @param subjectId, classId
     * @return ClassSubjectDTO
     */
    @Select("SELECT " +
            "   id AS classSubjectId " +
            "FROM " +
            "   public.class_subject " +
            "WHERE " +
            "   subject_id = #{subjectId} AND class_id = #{classId} ")
    String getClassSubjectId(@Param("subjectId") String subjectId,
                             @Param("classId") String classId);


    /**
     * Update status
     *
     * @param classId, subjectId
     * @return ClassSubjectDTO
     */
    @Update("UPDATE public.class_subject    " +
            "SET    " +
            "   status_id = '4' " +
            "WHERE  " +
            "   class_id = #{classId} AND subject_id = #{subjectId} ")
    int updateStatus(@Param("classId") String classId,
                     @Param("subjectId") String subjectId);
}
