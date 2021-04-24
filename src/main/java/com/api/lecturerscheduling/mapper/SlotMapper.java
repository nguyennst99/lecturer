package com.api.lecturerscheduling.mapper;

import com.api.lecturerscheduling.dto.ClassSubjectDTO;
import com.api.lecturerscheduling.dto.SlotDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface SlotMapper {
    /**
     * Select slot information
     * @param slotId
     * @return ClassSubjectDTO
     */
    @Select("SELECT " +
            "   id AS slotId, " +
            "   name AS slot, " +
            "   time, " +
            "   day " +
            "FROM " +
            "   public.slot " +
            "WHERE " +
            "   id = #{slotId} ")
    SlotDTO getSlotDTO(@Param("slotId") String slotId);

    /**
     * Select slot id
     * @param slot, day
     * @return ClassSubjectDTO
     */
    @Select("SELECT " +
            "   id AS slotId " +
            "FROM " +
            "   public.slot " +
            "WHERE " +
            "   name = #{slot} AND day = #{day} ")
    String getSlotId(@Param("slot") String slot,
                    @Param("day") String day);
}
