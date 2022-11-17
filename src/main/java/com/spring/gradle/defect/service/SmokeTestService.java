package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.dto.SmokeTestDto;
import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.SmokeTest;
import com.spring.gradle.defect.entity.Status;

public interface SmokeTestService {
	void saveTest(SmokeTestDto smokeTestDto);
	List<SmokeTest> getAllSmokeTests();
	SmokeTest getSmokeTestById(int id);
	void editSmokeById(SmokeTestDto smokeTestDto);




}
