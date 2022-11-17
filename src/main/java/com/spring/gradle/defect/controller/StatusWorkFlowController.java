package com.spring.gradle.defect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gradle.defect.dto.StatusWorkFlowDto;
import com.spring.gradle.defect.service.StatusWorkFlowService;

@RequestMapping("/statusWork")
@RestController
public class StatusWorkFlowController {

	@Autowired
	private StatusWorkFlowService statusWorkFlowService;

	@PostMapping("/saveStatusWork")
	public ResponseEntity<Object> saveStatusWorkFlow(@RequestBody StatusWorkFlowDto statusWorkFlowDto) {
		statusWorkFlowService.createStatusWorkFlow(statusWorkFlowDto);
		return ResponseEntity.ok("Status workflow saved");

	}

	// GET ALL
	@GetMapping("/getAll")
	public ResponseEntity<Object> getStatusWorkFlow() {
		return ResponseEntity.ok(statusWorkFlowService.getAllStatusWorkFlow());
	}

	// Get By id
	@GetMapping("/getById")
	public ResponseEntity<Object> getStatusWorkFlow(@PathVariable int id) {
		return ResponseEntity.ok(statusWorkFlowService.getStatusWorkFlowById(id));
	}

	@PutMapping("/editStatusWork")
	public ResponseEntity<Object> editStatusWorkFlow(@RequestBody StatusWorkFlowDto statusWorkFlowDto) {
		statusWorkFlowService.updateStatusWorkFlow(statusWorkFlowDto);
		return ResponseEntity.ok("StatusWork edited");
	}

}
