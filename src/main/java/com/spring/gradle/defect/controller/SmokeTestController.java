package com.spring.gradle.defect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gradle.defect.dto.SmokeTestDto;
import com.spring.gradle.defect.service.SmokeTestService;
import com.spring.gradle.defect.util.Constants;

@RequestMapping("/smokeTest")
@RestController
public class SmokeTestController {

	@Autowired
	private SmokeTestService smoketestService;

	@PostMapping("/saveTest")
	public ResponseEntity<Object>saveTest(@RequestBody SmokeTestDto smokeTestDto){
		smoketestService.saveTest(smokeTestDto);
		return ResponseEntity.ok("Test saved");
		
	}

	@PostMapping("/editTest")
	public ResponseEntity<Object> editTest(@RequestBody SmokeTestDto smokeTestDto) {
		smoketestService.editSmokeById(smokeTestDto);
		return ResponseEntity.ok("Test edited");
	}

	//create

	// GET ALL SmokeTests
	@GetMapping(Constants.GETALLSMOKE)
	public ResponseEntity<Object> getSmokeTests() {
		return ResponseEntity.ok(smoketestService.getAllSmokeTests());
	}

	// Get By id
	@GetMapping(Constants.GETBYSMOKEID)
	public ResponseEntity<Object> getSmokeTests(@PathVariable int id) {
		return ResponseEntity.ok(smoketestService.getSmokeTestById(id));
	}




	
}
