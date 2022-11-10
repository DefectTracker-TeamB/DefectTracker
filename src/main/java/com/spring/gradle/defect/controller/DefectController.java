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
			Defect defect = new Defect();
			BeanUtils.copyProperties(defectDto, defect);
			defectService.saveDefect(defect);
			return ResponseEntity.ok(" Defect Successfully created!");

		}
		
		
	// Get all defects
		@GetMapping(Constants.GET_ALLDEFECT) 
		public ResponseEntity<Object> getDefect() {
			List<DefectDto>defectDtos = defectService.getAllDefect();
			return ResponseEntity.ok(defectDtos);
		}


	//Get defect
		@GetMapping(Constants.GET_DEFECT)
		public ResponseEntity<Object> getDefectById(@PathVariable Long id) {
			return ResponseEntity.ok(defectService.getDefectById(id));
			}

		
		//update defect
	@PutMapping(Constants.PUT_DEFECT)
	public Defect updateDefect(@RequestBody Defect defect) {
		 System.out.println("Successfully update!");
		 defectService.updateDefect(defect);
		 return defect;
		}
		
	//Delete defect
	@DeleteMapping(Constants.DELE_DEFECT)
	public ResponseEntity<Object>deleteDefect(@PathVariable Long id){
		defectService.deleteDefect(id);
		return ResponseEntity.ok("Delete Successfully!");
	}

	
}
