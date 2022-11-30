package com.spring.gradle.defect.dto;

public class NotificationDto {
	private long id;
	private String message;
//	private String content;
//	private Long notificationId;
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public Long getNotificationId() {
//		return notificationId;
//	}
//	public void setNotificationId(Long notificationId) {
//		this.notificationId = notificationId;
//	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
