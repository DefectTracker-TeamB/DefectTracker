package com.spring.gradle.defect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusDto {
    private int defect_id;
	private int id;
	private String status;
	private String status_name;
	private String change_date;
	private String description;

}

