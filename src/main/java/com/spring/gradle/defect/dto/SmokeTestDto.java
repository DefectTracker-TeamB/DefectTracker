package com.spring.gradle.defect.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SmokeTestDto {
	private int id;
	private String post_by;
	private String status;
	private String description;
	private int releases_id;


}
