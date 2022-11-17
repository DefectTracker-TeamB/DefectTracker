package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.service.ReleaseService;

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

import com.spring.gradle.defect.dto.ReleaseDto;
import com.spring.gradle.defect.util.*;


@RestController
@RequestMapping("/release")
public class ReleaseController {
	
	@Autowired
	private ReleaseService releaseService;
	
	
	Logger log = LoggerFactory.getLogger(ReleaseController.class);

	
	//Create
	@PostMapping(Constants.CREATERELEASE)
	public ResponseEntity<Object> createRelease(@RequestBody ReleaseDto releaseDto){
		releaseService.createRelease(releaseDto);
		log.info("release created");
		log.error("Can not create the release", releaseDto);
		return ResponseEntity.ok("Release created");
		
		
		
	}
	
	//Get All
	@GetMapping(Constants.GETALLRELEASE)
	public ResponseEntity<Object> getRelease() {
		log.info("releases displayed");
		log.error("Unable to display the releases", releaseService);
		return ResponseEntity.ok(releaseService.getAllRelease());
	}
	
	
	//Get by id
	@GetMapping(Constants.GETBYRELEASEID)
	public ResponseEntity<Object> getRelease(@PathVariable int id) {
		log.info("release displayed");
		log.error("Unable to display the release with id", releaseService);
		return ResponseEntity.ok(releaseService.getReleaseById(id));
	}
	//Delete
    @DeleteMapping(Constants.DELETERELEASE)
	public ResponseEntity<Object> deleteRelease(@PathVariable int id) {
	releaseService.deleteRelease(id);
	log.info("release deleted");
	log.error("Unable to delete the release with id", releaseService);
	return ResponseEntity.ok("Deleted Successfully");
}

//Update
	@PutMapping(Constants.UPDATERELEASE) // ("/update")
	public ResponseEntity<Object> updateRelease(@RequestBody ReleaseDto releaseDto) {
		releaseService.updateRelease(releaseDto);
		log.info("release updated");
		log.error("Unable to update the release", releaseService);
		return ResponseEntity.ok("edited successfully");
	}
	

}
