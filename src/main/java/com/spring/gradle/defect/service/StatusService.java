package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;

public interface StatusService {
	
	  public void saveStatus(Status status);

		public List<StatusDto> getAllStatus();

		public StatusDto getStatusById(Long id);

		public void deleteStatus(Long id);

		public void updateStatus(Status status);

}
