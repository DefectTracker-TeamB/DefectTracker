package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.SmokeTestDto;
import com.spring.gradle.defect.entity.SmokeTest;

public interface SmokeTestService {
	void saveTest(SmokeTestDto smokeTestDto);
	List<SmokeTest> getAllSmokeTests();
	SmokeTest getSmokeTestById(int id);
	void editSmokeById(SmokeTestDto smokeTestDto);




}
