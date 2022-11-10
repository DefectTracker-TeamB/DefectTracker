package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;

public interface StatusService {
  void saveStatus(Status status);
StatusDto getStatusById(Long id);
Status updateStatus(Status status);
void deleteStatus(Long id);
List<Status> getAllStatus();
}
