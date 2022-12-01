package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.ReleaseDto;
import com.spring.gradle.defect.service.ReleaseService;
import com.spring.gradle.defect.util.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/release")
public class ReleaseController {

	@Autowired
	private ReleaseService releaseService;

	Logger log = LoggerFactory.getLogger(ReleaseController.class);

	// Create
	@PostMapping(Constants.CREATERELEASE)
	public ResponseEntity<Object> createRelease(@RequestBody ReleaseDto releaseDto) {
		// releaseService.createRelease(releaseDto);
		log.info("Entered to release");
		releaseService.createRelease(releaseDto);

		log.info("Datas sent to release service");
		log.error("Unable to create release", releaseDto);
		return ResponseEntity.ok("Release created");

	}

	// Get All
	@GetMapping(Constants.GETALLRELEASE)
	public ResponseEntity<Object> getRelease() {
		log.info("Entered to release");
		log.info("Datas displayed from release database");
		log.error("Can not to view the release details", releaseService);
		return ResponseEntity.ok(releaseService.getAllRelease());
	}

	// Get by id
	@GetMapping(Constants.GETBYRELEASEID)
	public ResponseEntity<Object> getRelease(@PathVariable int id) {
		log.info("Entered to release");
		log.info("Data displayed from release database");
		log.error("Can not to view the release detail", releaseService);
		return ResponseEntity.ok(releaseService.getReleaseById(id));
	}

	// Delete
	@DeleteMapping(Constants.DELETERELEASE)
	public ResponseEntity<Object> deleteRelease(@PathVariable int id) {
		// releaseService.deleteRelease(id);
		log.info("Entered to release");
		releaseService.deleteRelease(id);

		log.info("Datas delete from release service");
		log.error("Can not to delete the release detail", releaseService);
		return ResponseEntity.ok("Deleted Successfully");
	}

	// Update
	@PutMapping(Constants.UPDATERELEASE) // ("/update")
	public ResponseEntity<Object> updateRelease(@RequestBody ReleaseDto releaseDto) {
		// releaseService.updateRelease(releaseDto);
		log.info("Entered to release");
		releaseService.updateRelease(releaseDto);

		log.info("Datas update from release service");
		log.error("Can not to update the release detail", releaseService);
		return ResponseEntity.ok("edited successfully");
	}

}
