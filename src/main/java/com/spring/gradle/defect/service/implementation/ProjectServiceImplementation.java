package com.spring.gradle.defect.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.dto.ProjectDto;
import com.spring.gradle.defect.entity.Project;
import com.spring.gradle.defect.repository.ProjectRepository;
import com.spring.gradle.defect.service.ProjectService;

@Service
public class ProjectServiceImplementation implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	// create
	@Override
	public void createProject(Project project) {
		projectRepository.save(project);

	}

	// getAll
	@Override
	public List<ProjectDto> getAllProject() {
		List<ProjectDto> proDtos = new ArrayList<>();
		List<Project> projects = projectRepository.findAll();

		for (Project project : projects) {
			ProjectDto proDto = new ProjectDto();
			BeanUtils.copyProperties(project, proDto);
			proDtos.add(proDto);

		}
		return proDtos;
	}

	// getById
	@Override
	public ProjectDto getProjectById(int proId) {
		Project project = projectRepository.findById(proId).get();
		ProjectDto proDto = new ProjectDto();
		BeanUtils.copyProperties(project, proDto);

		return proDto;
	}

	// delete
	@Override
	public void deleteProject(int proId) {
		projectRepository.deleteById(proId);

	}

	// update
	@Override
	public void updateProject(Project project) {
		Project exitProject = projectRepository.findById(project.getProId()).get();
		BeanUtils.copyProperties(project, exitProject);
		projectRepository.save(exitProject);

	}

}
