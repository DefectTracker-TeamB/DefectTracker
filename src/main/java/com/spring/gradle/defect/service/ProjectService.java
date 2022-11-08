package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.ProjectDto;
import com.spring.gradle.defect.entity.Project;

public interface ProjectService {
	public void createProject(Project project);
	public List<ProjectDto>getAllProject();
	public ProjectDto getProjectById(int proId);
	public void deleteProject(int proId);
	public void updateProject(Project project);
}
