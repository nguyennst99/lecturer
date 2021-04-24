package com.api.lecturerscheduling.mapper;

import com.api.lecturerscheduling.dto.ClassTimeTableDTO;
import com.api.lecturerscheduling.dto.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClassTimeTableMapper {
    /**
     * Insert Class TimeTable
     * @param classTimeTableDTO
     * @return
     */
    @Insert("INSERT INTO public.class_timetable ( " +
            "   class_subject_id, " +
            "   course_user_id " +
            ") VALUES ( " +
            "   #{classSubjectId}, " +
            "   #{courseUserId} " +
            ");")
    Integer insClassTimeTable(ClassTimeTableDTO classTimeTableDTO);

    /**
     * Select id
     * @param
     * @return
     */
    @Select("SELECT " +
            "   MAX(id) AS classTimeTableMax " +
            "FROM " +
            "   public.class_timetable " +
            "WHERE " +
            "   '1' = '1'")
    int getClassTimeTableMax();
}
