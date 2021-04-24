package com.api.lecturerscheduling.mapper;

import com.api.lecturerscheduling.dto.ClassTimeTableDTO;
import com.api.lecturerscheduling.dto.TimeTableCreateDTO;
import com.api.lecturerscheduling.dto.TimeTableInfoAdminDTO;
import com.api.lecturerscheduling.dto.TimeTableSubDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TimeTableMapper {
    /**
     * Select time table information
     * @param user_id, semester, dateFrom, dateTo
     * @return TimeTableSubInfo
     */
    @Select("SELECT " +
            "   pw.first AS dateFrom, " +
            "   pw.last AS dateTo, " +
            "   pw.semester, " +
            "   ps.name AS slotName, " +
            "   ps.time AS slotTime, " +
            "   ps.day AS slotDay, " +
            "   pr.name AS roomName, " +
            "   psu.subject_name AS subjectName, " +
            "   pcl.class_id AS classId, " +
            "   psu.id AS subject " +
            "FROM " +
            "   public.timetable pt " +
            "LEFT JOIN " +
            "   public.week pw " +
            "   ON pt.week_id = pw.id " +
            "LEFT JOIN " +
            "   public.slot ps " +
            "   ON pt.slot_id = ps.id " +
            "LEFT JOIN " +
            "   public.room pr " +
            "   ON pt.room_id = pr.id " +
            "LEFT JOIN " +
            "   public.class_timetable pct " +
            "   ON pt.class_timetable_id = pct.id " +
            "LEFT JOIN " +
            "   public.course_user pcu " +
            "   ON pct.course_user_id = pcu.id " +
            "LEFT JOIN " +
            "   public.course pc " +
            "   ON pcu.course_id = pc.id " +
            "LEFT JOIN " +
            "   public.subject psu " +
            "   ON pc.subject_id = psu.id " +
            "LEFT JOIN " +
            "   public.class_subject pcl " +
            "   ON pct.class_subject_id = pcl.id " +
            "WHERE " +
            "   pc.status_id = '1' " +
            "   AND pcu.user_id = #{user_id} " +
            "   AND pw.first = #{dateFrom} " +
            "   AND pw.last = #{dateTo} " +
            "   AND pw.semester = #{semester}" +
            "   AND pt.status_id = '4' ")
    List<TimeTableSubDTO> getTimeTableSubInfo(@Param("user_id") String user_id,
                                              @Param("dateFrom") String dateFrom,
                                              @Param("dateTo") String dateTo,
                                              @Param("semester") String semester);


    @Insert("INSERT INTO public.timetable ( " +
            "   class_timetable_id, " +
            "   slot_id, " +
            "   week_id," +
            "   room_id, " +
            "   status_id " +
            ") VALUES ( " +
            "   #{classTimeTableId}, " +
            "   #{slotId}, " +
            "   #{weekId}," +
            "   #{roomId}," +
            "   '3' " +
            ");")
    Integer insTimeTable(TimeTableCreateDTO timeTableCreateDTO);


    /**
     * Select time table information for admin
     * @param
     * @return TimeTableSubInfo
     */
    @Select("SELECT  " +
            "    ps.name AS slotName, " +
            "    ps.time AS slotTime, " +
            "    ps.day AS slotDay, " +
            "    pcl.subject_id AS subjectId, " +
            "    pcl.class_id AS classId, " +
            "    pt.id AS timeTableId, " +
            "    pst.name AS statusId " +
            "FROM public.timetable pt " +
            "    LEFT JOIN public.slot ps ON pt.slot_id = ps.id " +
            "    LEFT JOIN public.class_timetable pct ON pt.class_timetable_id = pct.id " +
            "    LEFT JOIN public.course_user pcu ON pct.course_user_id = pcu.id " +
            "    LEFT JOIN public.status pst ON pst.id = pt.status_id " +
            "    LEFT JOIN public.class_subject pcl ON pct.class_subject_id = pcl.id " +
            "WHERE  pcu.user_id = #{userId} AND pt.week_id = '1'" )
    List<TimeTableInfoAdminDTO> getTimeTableForAdmin(@Param("userId") String userId);


    @Update("UPDATE public.timetable    " +
            "SET    " +
            "   status_id = #{statusId} " +
            "WHERE  " +
            "   id = #{classTimeTableId} ")
    int updStatus(@Param("statusId") String statusId,
                  @Param("classTimeTableId") int classTimeTableId);

    @Select("SELECT " +
            "       pt.slot_id " +
            "FROM " +
            "     public.timetable pt" +
            "     LEFT JOIN public.class_timetable pct ON pt.class_timetable_id = pct.id" +
            "     LEFT JOIN public.course_user pcu ON pct.course_user_id = pcu.id" +
            "     LEFT JOIN public.class_subject pcl ON pct.class_subject_id = pcl.id " +
            "WHERE " +
            "      pcu.user_id = #{userId} AND pt.week_id = '1' AND pt.slot_id=#{slotId}")
    String getSlotId(@Param("userId") String userId,
                     @Param("slotId") String slotId);
}
