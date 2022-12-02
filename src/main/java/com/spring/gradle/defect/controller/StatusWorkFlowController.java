package com.spring.gradle.defect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	Logger log = LoggerFactory.getLogger(StatusWorkFlowController.class);


	@PostMapping("/saveStatusWork")
	public ResponseEntity<Object> saveStatusWorkFlow(@RequestBody StatusWorkFlowDto statusWorkFlowDto) {
		log.info("Entered to StatusWorkFlow");
		statusWorkFlowService.createStatusWorkFlow(statusWorkFlowDto);
		log.info("Datas sent to StatusWorkFlow service");
		log.error("Unable to create StatusWorkFlow", statusWorkFlowDto);
		return ResponseEntity.ok("Status workflow saved");

	}

	// GET ALL
	@GetMapping("/getAll")
	public ResponseEntity<Object> getStatusWorkFlow() {
		log.info("Entered to StatusWorkFlow");
		log.info("Datas displayed from StatusWorkFlow database");
		log.error("Can not to view the StatusWorkFlow details", statusWorkFlowService);
		return ResponseEntity.ok(statusWorkFlowService.getAllStatusWorkFlow());
	}

	// Get By id
	@GetMapping("/getById")
	public ResponseEntity<Object> getStatusWorkFlow(@PathVariable Long id) {
		log.info("Entered to StatusWorkFlow");
		log.info("Data displayed from StatusWorkFlow database");
		log.error("Can not to view the StatusWorkFlow detail", statusWorkFlowService);
		return ResponseEntity.ok(statusWorkFlowService.getStatusWorkFlowById(id));
	}

	@PutMapping("/editStatusWork")
	public ResponseEntity<Object> editStatusWorkFlow(@RequestBody StatusWorkFlowDto statusWorkFlowDto) {
		log.info("Entered to StatusWorkFlow");
		statusWorkFlowService.updateStatusWorkFlow(statusWorkFlowDto);
		log.info("Datas update from StatusWorkFlow service");
		log.error("Can not to update the StatusWorkFlow detail", statusWorkFlowService);
		return ResponseEntity.ok("StatusWork edited");
	}

}
