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

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;
import com.spring.gradle.defect.service.StatusService;
import com.spring.gradle.defect.util.Constants;

@RequestMapping("/status")
@RestController
public class StatusController {
	@Autowired
	StatusService statusService;

	// Create
	@PostMapping(Constants.CREATESTATUS)
	public ResponseEntity<Object> createStatus(@RequestBody StatusDto statusDto) {
		Status status = new Status();
		BeanUtils.copyProperties(statusDto, status);
		statusService.saveStatus(status);
		return ResponseEntity.ok(" Status Successfully created!");

	}

	// Get all
	@GetMapping(Constants.GET_ALLSATATUS)
	public ResponseEntity<Object> getStatus() {
		List<StatusDto> statusDtos = statusService.getAllStatus();
		return ResponseEntity.ok(statusDtos);
	}

	// Get Status
	@GetMapping(Constants.GET_SATATUS)
	public ResponseEntity<Object> getStatusById(@PathVariable Long id) {
		return ResponseEntity.ok(statusService.getStatusById(id));
	}

	// update
	@PutMapping(Constants.PUT_SATATUS)
	public Status updateStatus(@RequestBody Status status) {
		System.out.println("Successfully update!");
		statusService.updateStatus(status);
		return status;
	}

	// Delete
	@DeleteMapping(Constants.DELE_STATUS)
	public ResponseEntity<Object> deleteStatus(@PathVariable Long id) {
		statusService.deleteStatus(id);
		return ResponseEntity.ok("Delete Successfully!");
	}
}
