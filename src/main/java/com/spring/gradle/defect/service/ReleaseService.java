package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.ReleaseDto;
import com.spring.gradle.defect.entity.Release;

public interface ReleaseService {
	public void cretaeRelease(Release release);
	public List<ReleaseDto>getAllRelease();
	public ReleaseDto getReleaseById(int id);
	public void updateRelease(Release release);
	public void deleteRelease (int id);
}
