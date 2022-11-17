package com.spring.gradle.defect.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ProjectDto {
	private int proId;
	private String name;
	private String startDate;
	private String endDate;
	private String description;
	private String uploadFile;
}
