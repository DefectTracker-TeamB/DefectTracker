package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;

import java.util.List;

public interface StatusService {


    void saveStatus(Status status);

    List<StatusDto> getAllStatus();

    StatusDto getStatusById(Long id);

    void deleteStatus(Long id);

    void updateStatus(Status status);

}
