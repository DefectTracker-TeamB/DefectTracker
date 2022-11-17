package com.spring.gradle.defect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	Logger log = LoggerFactory.getLogger(SmokeTestController.class);


	@PostMapping("/saveTest")
	public ResponseEntity<Object>saveTest(@RequestBody SmokeTestDto smokeTestDto){
		smoketestService.saveTest(smokeTestDto);
		log.info("Smoke test created");
		log.error("Can not create the smoke test", smokeTestDto);
		return ResponseEntity.ok("Test saved");
	}
	@PostMapping("/editTest")
	public ResponseEntity<Object>editTest(@RequestBody SmokeTestDto smokeTestDto){
		smoketestService.editSmokeById(smokeTestDto);
		log.info("Smoke test updated");
		log.error("Unable to update the smoke test", smokeTestDto);
		return ResponseEntity.ok("Test edited");
	}

	//create

	// GET ALL SmokeTests
	@GetMapping(Constants.GETALLSMOKE)
	public ResponseEntity<Object> getSmokeTests() {
		log.info("Smoke tests displayed");
		log.error("Unable to display the smoke tests", smoketestService);
		return ResponseEntity.ok(smoketestService.getAllSmokeTests());
	}

	// Get By id
	@GetMapping(Constants.GETBYSMOKEID)
	public ResponseEntity<Object> getSmokeTests(@PathVariable int id) {
		log.info("Smoke test displayed");
		log.error("Unable to display the smoke test", smoketestService);
		return ResponseEntity.ok(smoketestService.getSmokeTestById(id));
	}




	
}
