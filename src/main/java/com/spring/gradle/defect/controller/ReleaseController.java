package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.service.ReleaseService;
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

import com.spring.gradle.defect.dto.ReleaseDto;
import com.spring.gradle.defect.util.*;


@RestController
@RequestMapping("/release")
public class ReleaseController {
	
	@Autowired
	private ReleaseService releaseService;
	
	//Create
	@PostMapping(Constants.CREATERELEASE)
	public ResponseEntity<Object> createRelease(@RequestBody ReleaseDto releaseDto){
		releaseService.createRelease(releaseDto);
		return ResponseEntity.ok("Release created");
		
		
		
	}
	
	//Get All
	@GetMapping(Constants.GETALLRELEASE)
	public ResponseEntity<Object> getRelease() {
		return ResponseEntity.ok(releaseService.getAllRelease());
	}
	
	
	//Get by id
	@GetMapping(Constants.GETBYRELEASEID)
	public ResponseEntity<Object> getRelease(@PathVariable int id) {
		return ResponseEntity.ok(releaseService.getReleaseById(id));
	}
	//Delete
    @DeleteMapping(Constants.DELETERELEASE)
	public ResponseEntity<Object> deleteRelease(@PathVariable int id) {
	releaseService.deleteRelease(id);
	return ResponseEntity.ok("Deleted Successfully");
}

//Update
	@PutMapping(Constants.UPDATERELEASE) // ("/update")
	public ResponseEntity<Object> updateRelease(@RequestBody ReleaseDto releaseDto) {
		releaseService.updateRelease(releaseDto);
		return ResponseEntity.ok("edited successfully");
	}
	

}
