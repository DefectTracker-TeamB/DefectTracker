package com.spring.gradle.defect.controller;

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

import com.spring.gradle.defect.dto.ProjectDto;
import com.spring.gradle.defect.service.ProjectService;
import com.spring.gradle.defect.util.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	// Create project
	@PostMapping(Constants.CREATEPROJECT) // ("/create")
	public ResponseEntity<Object> createProject(@RequestBody ProjectDto projectDto) {
		projectService.createProject(projectDto);
		return ResponseEntity.ok("Project created");

	}

	// GetAll
	@GetMapping(Constants.GETALLPROJECT) // ("/getAll")
	public ResponseEntity<Object> getProject() {
		return ResponseEntity.ok(projectService.getAllProject());
	}

	// GetById
	@GetMapping(Constants.GETBYPROJECTID) // ("/getById")
	public ResponseEntity<Object> getProject(@PathVariable int id) {
		return ResponseEntity.ok(projectService.getProjectById(id));
	}

	// Delete
	@DeleteMapping(Constants.DELETEPROJECT) // ("/delete/{id}")
	public ResponseEntity<Object> deleteProject(@PathVariable int id) {
		projectService.deleteProject(id);
		return ResponseEntity.ok("Successfully deleted");
	}

	// Update
	@PutMapping(Constants.UPDATEPROJECT) // ("/update")
	public ResponseEntity<Object> updateProject(@RequestBody ProjectDto projectDto) {
		projectService.updateProject(projectDto);
		return ResponseEntity.ok("Successfully deleted");
	}
}
