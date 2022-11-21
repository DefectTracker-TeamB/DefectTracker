package com.spring.gradle.defect.dto;

import java.util.List;

import com.spring.gradle.defect.entity.Status;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class StatusWorkFlowDto {
	private Long id;
	private Status status;

	private List<Status> statusWorkflow;

}
