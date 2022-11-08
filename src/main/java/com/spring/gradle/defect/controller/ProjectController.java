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

import com.spring.gradle.defect.dto.ProjectDto;
import com.spring.gradle.defect.entity.Project;
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
		Project project = new Project();
		BeanUtils.copyProperties(projectDto, project);
		projectService.createProject(project);
		return ResponseEntity.ok(project);

	}

	// GetAll
	@GetMapping(Constants.GETALLPROJECT) // ("/getAll")
	public ResponseEntity<Object> getProject() {
		List<ProjectDto> projectDtos = projectService.getAllProject();
		return ResponseEntity.ok(projectDtos);
	}

	// GetById
	@GetMapping(Constants.GETBYID) // ("/getById")
	public ResponseEntity<Object> getProject(@PathVariable int id) {
		ProjectDto projectDto = projectService.getProjectById(id);
		return ResponseEntity.ok(projectDto);
	}

	// Delete
	@DeleteMapping(Constants.DELETEPROJECT) // ("/delete/{id}")
	public ResponseEntity<Object> deleteProject(@PathVariable int id) {
		projectService.deleteProject(id);
		return ResponseEntity.ok(id);
	}

	// Update
	@PutMapping(Constants.UPDATEPROJECT) // ("/update")
	public ResponseEntity<Object> updateProject(@RequestBody ProjectDto projectDto) {
		Project project = new Project();
		BeanUtils.copyProperties(projectDto, project);
		projectService.updateProject(project);
		return ResponseEntity.ok(project);
	}
}
