package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.StatusDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.service.DefectService;
import com.spring.gradle.defect.util.Constants;

@RequestMapping("/defect")
@RestController
public class DefectController {
	
	@Autowired
	DefectService defectService;

	
	Logger log = LoggerFactory.getLogger(DefectController.class);


	 // Create defect
		@PostMapping(Constants.CREATEDEFECT) 
		public ResponseEntity<Object> createDefect(@RequestBody DefectDto defectDto) {
			defectService.saveDefect(defectDto);
			log.info("Defect created");
			log.error("Can not create the defect :%s\\n", defectDto);
			return ResponseEntity.ok(" Defect Successfully created!");

		}
		
		
	// Get all defects
		@GetMapping(Constants.GET_ALLDEFECT) 
		public ResponseEntity<Object> getDefect() {
			log.info("Defect deisplayed");
			log.error("Unable to view the defects :", defectService);
			return ResponseEntity.ok(defectService.getAllDefect());
		}


	//Get defect
		@GetMapping(Constants.GET_DEFECT)
		public ResponseEntity<Object> getDefectById(@PathVariable int id) {
			log.info("Defect deisplayed");
			log.error("Unable to view the defect with id :", defectService);
			return ResponseEntity.ok(defectService.getDefectById(id));
			}

		
		//update defect
	@PutMapping(Constants.PUT_DEFECT)
	public ResponseEntity<Object> updateDefect(@RequestBody DefectDto defectDto) {
		defectService.updateDefect(defectDto);
		log.info("Defect Updated");
		log.error("Can not update the defect :%s\\\\n :", defectService);
		return ResponseEntity.ok().body("Successfully edited");
		}
		
	//Delete defect
	@DeleteMapping(Constants.DELE_DEFECT)
	public ResponseEntity<Object>deleteDefect(@PathVariable int id){
	    defectService.deleteDefect(id);
		log.info("Defect deleted");
		log.error("Unable to delete the defect with id :", defectService);
		return ResponseEntity.ok("Delete Successfully!");
	}
	@PostMapping("/status")
	public ResponseEntity<Object>changeStatus(@RequestBody StatusDto statusDto){
			defectService.setStatus(statusDto);
			log.info("Defect status changed");
			log.error("Unable to change the defect status:", defectService);
			return ResponseEntity.ok("Status changed");
	}

	

}
