package com.spring.gradle.defect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDto {
	private long id;
	private String content;
	private String to_whome;
	
}
