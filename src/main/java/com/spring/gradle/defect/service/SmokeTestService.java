package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.SmokeTestDto;
import com.spring.gradle.defect.entity.SmokeTest;

public interface SmokeTestService {

	public void createSmokeTest(SmokeTest smokeTest);

	public List<SmokeTestDto> getSmokeTest();

	public SmokeTestDto getSmokeTestDto(Long id);

	public void deleteSmokeTest(Long id);

	public void updateSmokeTest(SmokeTest smokeTest);

}
