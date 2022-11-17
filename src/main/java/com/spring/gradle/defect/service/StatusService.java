package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;

public interface StatusService {

	public void saveStatus(StatusDto statusDto);

	public List<StatusDto> getAllStatus();

	public StatusDto getStatusById(int id);

	public void deleteStatus(int id);

	public void updateStatus(StatusDto statusDto);

	//public void saveStatus(Status status);

}
