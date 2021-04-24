package com.api.lecturerscheduling.controller;

import com.api.lecturerscheduling.dto.NotificationDTO;
import com.api.lecturerscheduling.entity.Notification;
import com.api.lecturerscheduling.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Notification", description = "Notification API")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }


    @Operation(summary = "Get notification by user", description = "Get all notification of user", tags = { "Notification" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found") })
    @GetMapping("/notification-user")
    public List<NotificationDTO> getNotificationByUser(@RequestParam("userId")String userId){
        List<NotificationDTO> lst = service.getNotificationByUser(userId);
        Collections.reverse(lst);
        return lst;
    }

    @Operation(summary = "Update status of notification", description = "Update status of notification by id to checked", tags = { "Notification" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found") })
    @GetMapping("/notification-status")
    public Integer updateStatusNotification(@RequestParam("id")int id){
        return service.updateStatusNotification(id);
    }

    @Operation(summary = "Count all unread notification", description = "Count all unread notification of user", tags = { "Notification" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found") })
    @GetMapping("/notification-new")
    public Integer countNewNotification(@RequestParam("userId")String userId){
        return service.countNewNotification(userId);
    }
}
