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

import com.spring.gradle.defect.dto.ModuleDto;
import com.spring.gradle.defect.entity.Module;

import com.spring.gradle.defect.service.ModuleService;
import com.spring.gradle.defect.util.*;

//import antlr.collections.List;

@RestController
@RequestMapping("module")
public class ModuleController {

	@Autowired
	private ModuleService moduleService;

	// Create
	@PostMapping(Constants.CREATEMODULE) // ("/createMod")
	public ResponseEntity<Object> createModule(@RequestBody ModuleDto moduleDto) {
		Module mod = new Module();
		BeanUtils.copyProperties(moduleDto, mod);
		moduleService.createModule(mod);
		return ResponseEntity.ok(mod);

	}

	// Get all
	@GetMapping(Constants.GETALLMODULE) // ("Modules")
	public ResponseEntity<Object> getModules() {
		List<ModuleDto> moduleDtos = moduleService.getModule();
		return ResponseEntity.ok(moduleDtos);
	}
//
	// Get By Id
	@GetMapping(Constants.GETBYMODULEID) // ("/module/{id}")
	public ResponseEntity<Object> getModule(@PathVariable int id) {
		ModuleDto moduleDto = moduleService.getModuleDto(id);
		return ResponseEntity.ok(moduleDto);
	}

	// Update
	@PutMapping(Constants.UPDATEMODULE) // ("/update/{id}")
	public ResponseEntity<Object> updateModule(@RequestBody ModuleDto moduleDto) {
		Module module = new Module();
		BeanUtils.copyProperties(moduleDto, module);
		moduleService.createModule(module);
		return ResponseEntity.ok(module);
	}

	// Delete
	@DeleteMapping(Constants.DELETEMODULE) // ("/delete/{id}")
	public ResponseEntity<Object> deleteModule(@PathVariable int id) {
		moduleService.deleteModule(id);
		return ResponseEntity.ok(id);
	}

}
