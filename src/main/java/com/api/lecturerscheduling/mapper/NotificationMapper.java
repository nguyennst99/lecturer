package com.api.lecturerscheduling.mapper;

import com.api.lecturerscheduling.dto.NotificationCreateDTO;
import com.api.lecturerscheduling.dto.NotificationDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NotificationMapper {
    /**
     * get notification by user
     *
     * @param userId
     * @return NotificationDTOList
     */
    @Select("SELECT public.notification.id, title, content, time, public.status.name AS status" +
            " FROM public.notification, public.status " +
            "WHERE user_id = #{userId} AND public.status.id = public.notification.status_id")
    List<NotificationDTO> getListNotificationByUser(@Param("userId")String userId);

    /**
     *
     * @param notificationCreateDTO
     * @return
     */
    @Insert("INSERT INTO notification(title, content, user_id, time, status_id) " +
            "values(" +
            "#{title}, " +
            "#{content}," +
            "#{userId}," +
            "#{time}, " +
            "#{statusId});")
    Integer insertNotification(NotificationCreateDTO notificationCreateDTO);

    /**
     *
     * @param id
     * @return
     */
    @Select("UPDATE notification SET status_id = 7 where id = #{id}")
    Integer updateStatusNotification(@Param("id")int id);

    @Select("SELECT COUNT(id) as total FROM notification WHERE status_id = '6' AND user_id = #{userId}")
    Integer countNewNotification(@Param("userId")String userId);
}
