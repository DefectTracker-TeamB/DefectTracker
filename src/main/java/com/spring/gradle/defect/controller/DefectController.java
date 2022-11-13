package com.spring.gradle.defect.controller;

import java.util.List;

import com.spring.gradle.defect.dto.StatusDto;
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

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.entity.Defect;
import com.spring.gradle.defect.service.DefectService;
import com.spring.gradle.defect.util.Constants;

@RequestMapping("/defect")
@RestController
public class DefectController {
	
	@Autowired
	DefectService defectService;


	 // Create defect
		@PostMapping(Constants.CREATEDEFECT) 
		public ResponseEntity<Object> createDefect(@RequestBody DefectDto defectDto) {
			defectService.saveDefect(defectDto);
			return ResponseEntity.ok(" Defect Successfully created!");

		}
		
		
	// Get all defects
		@GetMapping(Constants.GET_ALLDEFECT) 
		public ResponseEntity<Object> getDefect() {
			return ResponseEntity.ok(defectService.getAllDefect());
		}


	//Get defect
		@GetMapping(Constants.GET_DEFECT)
		public ResponseEntity<Object> getDefectById(@PathVariable int id) {
			return ResponseEntity.ok(defectService.getDefectById(id));
			}

		
		//update defect
	@PutMapping(Constants.PUT_DEFECT)
	public ResponseEntity<Object> updateDefect(@RequestBody DefectDto defectDto) {
		defectService.updateDefect(defectDto);
		return ResponseEntity.ok().body("Successfully edited");
		}
		
	//Delete defect
	@DeleteMapping(Constants.DELE_DEFECT)
	public ResponseEntity<Object>deleteDefect(@PathVariable int id){
		defectService.deleteDefect(id);
		return ResponseEntity.ok("Delete Successfully!");
	}
	@PostMapping("/status")
	public ResponseEntity<Object>changeStatus(@RequestBody StatusDto statusDto){
			defectService.setStatus(statusDto);
			return ResponseEntity.ok("status changed");
	}

	

}
