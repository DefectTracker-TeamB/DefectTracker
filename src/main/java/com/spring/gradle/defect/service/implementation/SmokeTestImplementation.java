package com.spring.gradle.defect.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.gradle.defect.dto.SmokeTestDto;
import com.spring.gradle.defect.entity.SmokeTest;
import com.spring.gradle.defect.repository.SmokeTestRepository;
import com.spring.gradle.defect.service.SmokeTestService;

@Service
public class SmokeTestImplementation implements SmokeTestService {

	@Autowired
	private SmokeTestRepository smokeRepository;

	@Override
	public void createSmokeTest(SmokeTest smokeTest) {
		smokeRepository.save(smokeTest);

	}

	@Override
	public List<SmokeTestDto> getSmokeTest() {
		// TODO Auto-generated method stub

		List<SmokeTestDto> smokeTestDtos = new ArrayList<>();
		List<SmokeTest> smokeTests = smokeRepository.findAll();

		for (SmokeTest smokeTest : smokeTests) {
			SmokeTestDto smokeTestDto = new SmokeTestDto();
			BeanUtils.copyProperties(smokeTest, smokeTestDto);
			smokeTestDtos.add(smokeTestDto);
		}
		return smokeTestDtos;
	}

	@Override
	public SmokeTestDto getSmokeTestDto(Long id) {
		SmokeTest smokeTest = smokeRepository.findById(id).get();
		SmokeTestDto smokeTestDto = new SmokeTestDto();
		BeanUtils.copyProperties(smokeTest, smokeTestDto);

		return smokeTestDto;
	}

	@Override
	public void deleteSmokeTest(Long id) {
		smokeRepository.deleteById(id);

	}

	@Override
	public void updateSmokeTest(SmokeTest smokeTest) {
		SmokeTest exitSmokeTest = smokeRepository.findById(smokeTest.getId()).get();
		BeanUtils.copyProperties(smokeTest, exitSmokeTest);
		smokeRepository.save(exitSmokeTest);
		 

	}

}
