package com.api.lecturerscheduling.service.impl;

import com.api.lecturerscheduling.dto.NotificationCreateDTO;
import com.api.lecturerscheduling.dto.NotificationDTO;
import com.api.lecturerscheduling.mapper.NotificationMapper;
import com.api.lecturerscheduling.service.NotificationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {


    private final NotificationMapper notificationMapper;

    public NotificationServiceImpl(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @Override
    public List<NotificationDTO> getNotificationByUser(String userId) {
        return notificationMapper.getListNotificationByUser(userId);
    }

    @Override
    public Integer insertNotification(NotificationCreateDTO notificationCreateDTO) {
        return notificationMapper.insertNotification(notificationCreateDTO);
    }

    @Override
    public Integer updateStatusNotification(int id) {
        return notificationMapper.updateStatusNotification(id);
    }

    @Override
    public Integer countNewNotification(String userId) {
        return notificationMapper.countNewNotification(userId);
    }


}
