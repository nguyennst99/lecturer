package com.api.lecturerscheduling.controller;

import com.api.lecturerscheduling.dto.NotificationCreateDTO;
import com.api.lecturerscheduling.dto.PnsRequest;
import com.api.lecturerscheduling.service.FCMService;
import com.api.lecturerscheduling.service.NotificationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

@CrossOrigin
@RestController
@Tag(name = "PushNotificationFCM", description = "Push Notification FCM API")
public class PushNotificationController {

    @Autowired
    private FCMService fcmService;

    @Autowired
    private NotificationService notificationService;

    @Operation(summary = "Send notification", description = "Send Notification To FCM", tags = { "PushNotificationFCM" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "There aren't notification") })
    @PostMapping("/notification")
    public String sendSampleNotification(@RequestBody PnsRequest pnsRequest) {
        return fcmService.pushNotification(pnsRequest);
    }

    @Operation(summary = "Send notification", description = "Send Notification To FCM", tags = { "PushNotificationFCM" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not found") })
    @GetMapping("/notification")
    public String sendSampleNotification2(@RequestParam String fcmToken,
                                          @RequestParam String title,
                                          @RequestParam String content,
                                          @RequestParam String userId) {
        PnsRequest pnsRequest = new PnsRequest(fcmToken, content, title);
        NotificationCreateDTO notificationCreateDTO = new NotificationCreateDTO();
        notificationCreateDTO.setContent(pnsRequest.getContent());
        notificationCreateDTO.setTitle(pnsRequest.getTitle());
        String date = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String time = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        notificationCreateDTO.setTime(date + " " + time);
        notificationCreateDTO.setStatusId("6");
        notificationCreateDTO.setUserId(userId);
        notificationService.insertNotification(notificationCreateDTO);
        return fcmService.pushNotification(pnsRequest);
    }
}
