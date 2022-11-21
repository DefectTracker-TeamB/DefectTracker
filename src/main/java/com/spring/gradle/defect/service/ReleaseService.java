package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.ReleaseDto;
import com.spring.gradle.defect.entity.Releases;

import java.util.List;

public interface ReleaseService {
    void createRelease(ReleaseDto releaseDto);

    List<Releases> getAllRelease();

    Releases getReleaseById(int id);

    void updateRelease(ReleaseDto releaseDto);

    void deleteRelease(int id);
}
