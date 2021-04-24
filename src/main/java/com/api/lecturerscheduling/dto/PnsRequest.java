package com.api.lecturerscheduling.dto;

public class PnsRequest {
    private String fcmToken;
    private String content;
    private String title;

    public PnsRequest(String fcmToken, String content, String title) {
        this.fcmToken = fcmToken;
        this.content = content;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
