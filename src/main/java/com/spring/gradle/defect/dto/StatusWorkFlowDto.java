package com.spring.gradle.defect.dto;

import java.util.List;

import com.spring.gradle.defect.entity.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusWorkFlowDto {
	private int id;
	private Status status;

	private List<Status> statusWorkflow;

}
