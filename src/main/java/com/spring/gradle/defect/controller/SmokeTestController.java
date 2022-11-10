package com.spring.gradle.defect.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gradle.defect.dto.SmokeTestDto;
import com.spring.gradle.defect.entity.SmokeTest;
import com.spring.gradle.defect.service.SmokeTestService;
import com.spring.gradle.defect.util.Constants;

@RequestMapping("/smokeTest")
@RestController
public class SmokeTestController {

	@Autowired
	private SmokeTestService smoketestService;

	//create
	@PostMapping(Constants.CREATESMOKETEST)
	public ResponseEntity<Object> saveSmokeTest(@RequestBody SmokeTestDto smoketestDto) {
		SmokeTest smoketest = new SmokeTest();
		BeanUtils.copyProperties(smoketestDto, smoketest);
		smoketestService.createSmokeTest(smoketest);
		return ResponseEntity.ok(smoketest);
	}

	// GET ALL SmokeTests
	@GetMapping(Constants.GETALLSMOKETEST)
	public ResponseEntity<Object> getSmokeTests() {
		List<SmokeTestDto> smoketestDtos = smoketestService.getSmokeTest();
		return ResponseEntity.ok(smoketestDtos);
	}

	// Get By Id
	@GetMapping(Constants.GETBYID)
	public ResponseEntity<Object> getSmokeTests(@PathVariable Long id) {
		SmokeTestDto smokeTestDto = smoketestService.getSmokeTestDto(id);
		return ResponseEntity.ok(smokeTestDto);
	}

	// Update
	@PutMapping(Constants.UPDATESMOKETEST)
	public ResponseEntity<Object> updateSmokeTests(@RequestBody SmokeTestDto smokeTestDto) {
		SmokeTest smoketest = new SmokeTest();
		BeanUtils.copyProperties(smokeTestDto, smoketest);
		smoketestService.updateSmokeTest(smoketest);
		return ResponseEntity.ok(smoketest);
	}

	 // Delete
	@DeleteMapping(Constants.DELETESMOKETEST) 
	public ResponseEntity<Object> deleteSmokeTests(@PathVariable Long id) {
		smoketestService.deleteSmokeTest(id);
		return ResponseEntity.ok(id);
	}
	 
	
}
