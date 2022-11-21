package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.SmokeTestDto;
import com.spring.gradle.defect.entity.SmokeTest;

import java.util.List;

public interface SmokeTestService {
    void saveTest(SmokeTestDto smokeTestDto);

    List<SmokeTest> getAllSmokeTests();

    SmokeTest getSmokeTestById(int id);

    void editSmokeById(SmokeTestDto smokeTestDto);


}
