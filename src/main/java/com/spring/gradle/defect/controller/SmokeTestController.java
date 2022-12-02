package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.SmokeTestDto;
import com.spring.gradle.defect.service.SmokeTestService;
import com.spring.gradle.defect.util.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/smokeTest")
@RestController
public class SmokeTestController {

	@Autowired
	private SmokeTestService smoketestService;

	Logger log = LoggerFactory.getLogger(SmokeTestController.class);

	@PostMapping("/saveTest")
	public ResponseEntity<Object> saveTest(@RequestBody SmokeTestDto smokeTestDto) {
		// smoketestService.saveTest(smokeTestDto);
		log.info("Entered to smokeTest");
		smoketestService.saveTest(smokeTestDto);

		log.info("Datas sent to smokeTest service");
		log.error("Unable to create smokeTest", smokeTestDto);
		return ResponseEntity.ok("Test saved");
	}

	@PostMapping("/editTest")
	public ResponseEntity<Object> editTest(@RequestBody SmokeTestDto smokeTestDto) {
		// smoketestService.editSmokeById(smokeTestDto);
		log.info("Entered to smokeTest");
		smoketestService.editSmokeById(smokeTestDto);
		log.info("Datas update from smokeTest service");
		log.error("Can not to update the smokeTest detail", smoketestService);
		return ResponseEntity.ok("Test edited");
	}

	// create

	// GET ALL SmokeTests
	@GetMapping(Constants.GETALLSMOKE)
	public ResponseEntity<Object> getSmokeTests() {
		log.info("Entered to smokeTest");
		log.info("Datas displayed from smokeTest database");
		log.error("Can not to view the smokeTest details", smoketestService);
		return ResponseEntity.ok(smoketestService.getAllSmokeTests());
	}

	// Get By id
	@GetMapping(Constants.GETBYSMOKEID)
	public ResponseEntity<Object> getSmokeTests(@PathVariable int id) {
		log.info("Entered to smokeTest");
		log.info("Data displayed from smokeTest database");
		log.error("Can not to view the smokeTest detail", smoketestService);
		return ResponseEntity.ok(smoketestService.getSmokeTestById(id));
	}

}
