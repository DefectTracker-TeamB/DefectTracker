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

import com.spring.gradle.defect.dto.ModuleDto;
import com.spring.gradle.defect.entity.Module;

import com.spring.gradle.defect.service.ModuleService;
import com.spring.gradle.defect.util.*;

//import antlr.collections.List;

@RestController
@RequestMapping("/module")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	Logger log = LoggerFactory.getLogger(DefectController.class);
	// Create
	@PostMapping(Constants.CREATEMODULE) // ("/createMod")
	public ResponseEntity<Object> createModule(@RequestBody ModuleDto moduleDto) {
		log.info("Entered to module");
		moduleService.createModule(moduleDto);
		log.info("Datas sent to module service");
		log.error("Unable to create module", moduleDto);
		return ResponseEntity.ok("Module created successfully");

	}

	// Get all
	@GetMapping(Constants.GETALLMODULE) // ("Modules")
	public ResponseEntity<Object> getAllModules() {
		log.info("Entered to Module");
		log.info("Datas displayed from module database");
		log.error("Can not to view the modules details", moduleService);
		return ResponseEntity.ok( moduleService.getAllModule());
	}
//
	// Get By Id
	@GetMapping(Constants.GETBYMODULEID) // ("/module/{id}")
	public ResponseEntity<Object> getModuleById(@PathVariable int id) {
		
		log.info("Entered to module");
		log.info("Data displayed from module database");
		log.error("Can not to view the module detail", moduleService);
		return ResponseEntity.ok(moduleService.getModuleById(id));
	}

	// Update
	@PutMapping(Constants.UPDATEMODULE) // ("/update/{id}")
	public ResponseEntity<Object> updateModule(@RequestBody ModuleDto moduleDto) {
		log.info("Entered to module");
		moduleService.updateModule(moduleDto);
		log.info("Datas update from module service");
		log.error("Can not to update the module detail", moduleService);
		return ResponseEntity.ok("Module Edited");
	}

	// Delete
	@DeleteMapping(Constants.DELETEMODULE) // ("/delete/{id}")
	public ResponseEntity<Object> deleteModule(@PathVariable int id) {
		log.info("Entered to module");
		moduleService.deleteModule(id);
		log.info("Datas delete from module service");
		log.error("Can not to delete the module detail", moduleService);
		return ResponseEntity.ok("Deleted successfully");
	}

}
