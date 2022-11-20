package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.ProjectDto;
import com.spring.gradle.defect.entity.Project;

import java.util.List;

public interface ProjectService {
    void createProject(ProjectDto projectDto);

    List<Project> getAllProject();

    Project getProjectById(int proId);

    void deleteProject(int proId);

    void updateProject(ProjectDto projectDto);
}