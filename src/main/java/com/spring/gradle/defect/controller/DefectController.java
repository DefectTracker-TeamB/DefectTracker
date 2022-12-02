package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.dto.StatusDto;


import com.spring.gradle.defect.service.DefectService;
import com.spring.gradle.defect.util.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/defect")
@RestController
public class DefectController {




	@Autowired
	DefectService defectService;

	Logger log = LoggerFactory.getLogger(DefectController.class);

	// Create defect
	@PostMapping(Constants.CREATEDEFECT)
	public ResponseEntity<Object> createDefect(@RequestBody DefectDto defectDto) {
		// defectService.saveDefect(defectDto);
		log.info("Entered to defect");
		defectService.saveDefect(defectDto);
		log.info("Datas sent to defect service");
		log.error("Unable to create defect", defectDto);
		return ResponseEntity.ok(" Defect Successfully created!");

	}

	// Get all defects
	@GetMapping(Constants.GET_ALLDEFECT)
	public ResponseEntity<Object> getDefect() {
		log.info("Entered to defect");
		log.info("Datas displayed from defect database");
		log.error("Can not to view the defect details", defectService);
		return ResponseEntity.ok(defectService.getAllDefect());
	}

	// Get defect
	@GetMapping(Constants.GET_DEFECT)
	public ResponseEntity<Object> getDefectById(@PathVariable int id) {
		log.info("Entered to defect");
		log.info("Data displayed from defect database");
		log.error("Can not to view the defect detail", defectService);
		return ResponseEntity.ok(defectService.getDefectById(id));
	}

	// update defect
	@PutMapping(Constants.PUT_DEFECT)
	public ResponseEntity<Object> updateDefect(@RequestBody DefectDto defectDto) {
		// defectService.updateDefect(defectDto);
		log.info("Entered to defect");
		defectService.updateDefect(defectDto);

		log.info("Datas update from defect service");
		log.error("Can not to update the defect detail", defectService);
		return ResponseEntity.ok().body("Successfully edited");

	}

	// Delete defect
	@DeleteMapping(Constants.DELE_DEFECT)
	public ResponseEntity<Object> deleteDefect(@PathVariable int id) {
		// defectService.deleteDefect(id);
		log.info("Entered to defect");
		defectService.deleteDefect(id);
		log.info("Datas delete from defect service");
		log.error("Can not to delete the defect detail", defectService);
		return ResponseEntity.ok("Delete Successfully!");
	}

	@PostMapping("/status")
	public ResponseEntity<Object> changeStatus(@RequestBody StatusDto statusDto) {
		// defectService.setStatus(statusDto);
		log.info("Entered to status");
		defectService.setStatus(statusDto);
		log.info("Status sent to defect service");
		log.error("Unable to change the defect status", defectService);
		return ResponseEntity.ok("status changed");
	}


}
