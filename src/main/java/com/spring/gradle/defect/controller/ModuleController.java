package com.spring.gradle.defect.controller;

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

import com.spring.gradle.defect.dto.ModuleDto;
import com.spring.gradle.defect.service.ModuleService;
import com.spring.gradle.defect.util.*;

//import antlr.collections.List;

@RestController
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;
	
	
	Logger log = LoggerFactory.getLogger(ModuleController.class);


	// Create
	@PostMapping(Constants.CREATEMODULE) // ("/createMod")
	public ResponseEntity<Object> createModule(@RequestBody ModuleDto moduleDto) {
		moduleService.createModule(moduleDto);
		log.info("Module created");
		log.error("can not create the module", moduleDto);
		return ResponseEntity.ok("Module created successfully");

	}

	// Get all
	@GetMapping(Constants.GETALLMODULE) // ("Modules")
	public ResponseEntity<Object> getAllModules() {
		log.info("Modules displayed");
		log.error("unable to view the modules", moduleService);
		return ResponseEntity.ok( moduleService.getAllModule());
	}
//
	// Get By Id
	@GetMapping(Constants.GETBYMODULEID) // ("/module/{id}")
	public ResponseEntity<Object> getModuleById(@PathVariable int id) {
		log.info("Module displayed");
		log.error("unable to view the module with id", moduleService);
		return ResponseEntity.ok(moduleService.getModuleById(id));
	}

	// Update
	@PutMapping(Constants.UPDATEMODULE) // ("/update/{id}")
	public ResponseEntity<Object> updateModule(@RequestBody ModuleDto moduleDto) {
		moduleService.updateModule(moduleDto);
		log.info("Module updated");
		log.error("unable to update the module", moduleService);
		return ResponseEntity.ok("Module Edited");
	}

	// Delete
	@DeleteMapping(Constants.DELETEMODULE) // ("/delete/{id}")
	public ResponseEntity<Object> deleteModule(@PathVariable int id) {
		moduleService.deleteModule(id);
		log.info("Module deleted");
		log.error("unable to delete the module", moduleService);
		return ResponseEntity.ok("Deleted successfully");
	}

}
