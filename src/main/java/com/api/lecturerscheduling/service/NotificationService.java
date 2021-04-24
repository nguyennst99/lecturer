package com.api.lecturerscheduling.service;

import com.api.lecturerscheduling.dto.NotificationCreateDTO;
import com.api.lecturerscheduling.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getNotificationByUser(String userId);
    Integer insertNotification(NotificationCreateDTO notificationCreateDTO);
    Integer updateStatusNotification(int id);
    Integer countNewNotification(String userId);
}
