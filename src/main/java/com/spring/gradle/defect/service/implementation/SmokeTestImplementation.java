package com.spring.gradle.defect.service.implementation;

import java.util.List;

import com.spring.gradle.defect.entity.Releases;
import com.spring.gradle.defect.repository.ReleaseRepository;
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
	@Autowired
	private ReleaseRepository releaseRepository;


	@Override
	public void saveTest(SmokeTestDto smokeTestDto) {
		SmokeTest smokeTest=new SmokeTest();
		Releases releases=releaseRepository.findById(smokeTestDto.getReleases_id()).get();
		smokeTest.setPost_by(smokeTestDto.getPost_by());
		smokeTest.setStatus(smokeTestDto.getStatus());
		smokeTest.setDescription(smokeTestDto.getDescription());
		smokeTest.setReleases(releases);
		smokeRepository.save(smokeTest);
	}

	@Override
	public List<SmokeTest> getAllSmokeTests() {
		// TODO Auto-generated method stub
		return smokeRepository.findAll();
	}

	@Override
	public SmokeTest getSmokeTestById(int id) {
		return  smokeRepository.findById(id).get();
	}

	@Override
	public void editSmokeById(SmokeTestDto smokeTestDto) {
		SmokeTest smokeTest=smokeRepository.findById(smokeTestDto.getId()).get();
		Releases releases=releaseRepository.findById(smokeTestDto.getReleases_id()).get();
		smokeTest.setPost_by(smokeTestDto.getPost_by());
		smokeTest.setStatus(smokeTestDto.getStatus());
		smokeTest.setDescription(smokeTestDto.getDescription());
		smokeTest.setReleases(releases);
		smokeRepository.save(smokeTest);
	}


}



