package com.spring.gradle.defect.service.implementation;

import com.spring.gradle.defect.dto.ProjectDto;
import com.spring.gradle.defect.entity.Project;
import com.spring.gradle.defect.repository.ProjectRepository;
import com.spring.gradle.defect.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImplementation implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // create
    @Override
    public void createProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setEndDate(projectDto.getDuration());
        project.setStartDate(projectDto.getStartDate());
        project.setUploadFile(projectDto.getUploadFile());
        projectRepository.save(project);

    }

    // getAll
    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    // getById
    @Override
    public Project getProjectById(int proId) {
        return projectRepository.findById(proId).get();
    }

    // delete
    @Override
    public void deleteProject(int proId) {
        projectRepository.deleteById(proId);

    }

    // update
    @Override
    public void updateProject(ProjectDto projectDto) {
        Project project = projectRepository.findById(projectDto.getProId()).get();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setEndDate(projectDto.getDuration());
        project.setStartDate(projectDto.getStartDate());
        project.setUploadFile(projectDto.getUploadFile());
        projectRepository.save(project);
    }
}
