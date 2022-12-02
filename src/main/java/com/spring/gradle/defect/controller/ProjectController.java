package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.ProjectDto;
import com.spring.gradle.defect.service.ProjectService;
import com.spring.gradle.defect.util.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	Logger log = LoggerFactory.getLogger(ProjectController.class);

	// Create project
	@PostMapping(Constants.CREATEPROJECT) // ("/create")
	public ResponseEntity<Object> createProject(@RequestBody ProjectDto projectDto) {
		// projectService.createProject(projectDto);
		log.info("Entered to project");
		projectService.createProject(projectDto);

		log.info("Datas sent to project service");
		log.error("Unable to create project", projectDto);
		return ResponseEntity.ok("Project created");

	}

	// GetAll
	@GetMapping(Constants.GETALLPROJECT) // ("/getAll")
	public ResponseEntity<Object> getProject() {
		log.info("Entered to project");
		log.info("Datas displayed from project database");
		log.error("Can not to view the project details", projectService);
		return ResponseEntity.ok(projectService.getAllProject());
	}

	// GetById
	@GetMapping(Constants.GETBYPROJECTID) // ("/getById")
	public ResponseEntity<Object> getProject(@PathVariable int id) {
		log.info("Entered to project");
		log.info("Data displayed from project database");
		log.error("Can not to view the project detail", projectService);
		return ResponseEntity.ok(projectService.getProjectById(id));
	}

	// Delete
	@DeleteMapping(Constants.DELETEPROJECT) // ("/delete/{id}")
	public ResponseEntity<Object> deleteProject(@PathVariable int id) {
		// projectService.deleteProject(id);
		log.info("Entered to project");
		projectService.deleteProject(id);

		log.info("Datas delete from project service");
		log.error("Can not to delete the project detail", projectService);
		return ResponseEntity.ok("Successfully deleted");
	}

	// Update
	@PutMapping(Constants.UPDATEPROJECT) // ("/update")
	public ResponseEntity<Object> updateProject(@RequestBody ProjectDto projectDto) {
		// projectService.updateProject(projectDto);
		log.info("Entered to project");
		projectService.updateProject(projectDto);

		log.info("Datas update from project service");
		log.error("Can not to update the project detail", projectService);
		return ResponseEntity.ok("Successfully deleted");
	}
}
