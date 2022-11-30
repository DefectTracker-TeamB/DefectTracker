package com.spring.gradle.defect.entity;

public class Notification {
	private String content;
	private Long notificationId;

    public Notification(String content, Long notificationId, Long userId, String datetime, boolean isOpened) {
		super();
		this.content = content;
		this.notificationId = notificationId;
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public Notification() {
    }

    public Notification(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
