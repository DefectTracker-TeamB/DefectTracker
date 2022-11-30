package com.spring.gradle.defect.service.implementation;

import com.spring.gradle.defect.dto.ReleaseDto;
import com.spring.gradle.defect.entity.Project;
import com.spring.gradle.defect.entity.Releases;
import com.spring.gradle.defect.repository.ProjectRepository;
import com.spring.gradle.defect.repository.ReleaseRepository;
import com.spring.gradle.defect.service.ReleaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReleaseServiceImplementation implements ReleaseService {


    @Autowired
    private ReleaseRepository releaseRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createRelease(ReleaseDto releaseDto) {
        Releases release = new Releases();
        Project project = projectRepository.findById(releaseDto.getProject_id()).orElse(new Project());
        release.setUpload_file(releaseDto.getUploadFile());
        release.setRelease_version(releaseDto.getReleaseVersion());
        release.setApi_link(releaseDto.getApiLink());
        release.setProject(project);
        releaseRepository.save(release);

    }

    @Override
    public List<Releases> getAllRelease() {
        return releaseRepository.findAll();
    }

    @Override
    public Releases getReleaseById(int id) {
        return releaseRepository.findById(id).get();
    }

    @Override
    public void updateRelease(ReleaseDto releaseDto) {
        Releases release = releaseRepository.findById(releaseDto.getId()).get();
        Project project = projectRepository.findById(releaseDto.getProject_id()).orElse(new Project());
        release.setUpload_file(releaseDto.getUploadFile());
        release.setRelease_version(releaseDto.getReleaseVersion());
        release.setApi_link(releaseDto.getApiLink());
        release.setProject(project);
        releaseRepository.save(release);

    }

    @Override
    public void deleteRelease(int id) {
        releaseRepository.deleteById(id);

    }
}
