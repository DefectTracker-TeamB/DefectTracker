package com.spring.gradle.defect.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;
import com.spring.gradle.defect.service.StatusService;
import com.spring.gradle.defect.util.Constants;

@RequestMapping("/status")
@RestController
public class StatusController {
	@Autowired
	StatusService statusService;
	
	
	Logger log = LoggerFactory.getLogger(StatusController.class);


	// Create
	@PostMapping(Constants.CREATESTATUS)
	public ResponseEntity<Object> createStatus(@RequestBody StatusDto statusDto) {
		StatusDto status = new StatusDto();
		BeanUtils.copyProperties(statusDto, status);
		statusService.saveStatus(status);
		log.info("Status created");
		log.error("Can not to create the status", status);
		return ResponseEntity.ok(" Status Successfully created!");

	}

	// Get all
	@GetMapping(Constants.GET_ALLSATATUS)
	public ResponseEntity<Object> getStatus() {
		List<StatusDto> statusDtos = statusService.getAllStatus();
		log.info("Status displayed");
		log.error("Unable to display the status", statusService);
		return ResponseEntity.ok(statusDtos);
	}

	// Get Status
	@GetMapping(Constants.GET_SATATUS)

	public ResponseEntity<Object> getStatusById(@PathVariable int id) {

	public ResponseEntity<Object> getStatusById(@PathVariable Long id) {
		log.info("Status displayed");
		log.error("Unable to display the status with id", statusService);

		return ResponseEntity.ok(statusService.getStatusById(id));
	}

	// update
	@PutMapping(Constants.PUT_SATATUS)
	public StatusDto updateStatus(@RequestBody StatusDto statusDto) {
		System.out.println("Successfully update!");

		statusService.updateStatus(statusDto);
		return statusDto;

		statusService.updateStatus(status);
		log.info("Status updated");
		log.error("Unable to update the status with id", statusService);
		return status;

	}

	// Delete
	@DeleteMapping(Constants.DELE_STATUS)
	public ResponseEntity<Object> deleteStatus(@PathVariable int id) {
		statusService.deleteStatus(id);
		log.info("Status deleted");
		log.error("Unable to delete the status with id", statusService);
		return ResponseEntity.ok("Delete Successfully!");
	}
}
