package com.spring.gradle.defect.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.dto.ReleaseDto;
import com.spring.gradle.defect.entity.Release;
import com.spring.gradle.defect.repository.ReleaseRepository;
import com.spring.gradle.defect.service.ReleaseService;


@Service
public class ReleaseServiceImplementation implements ReleaseService {

	@Autowired
	private ReleaseRepository releaseRepo;

	@Override
	public void cretaeRelease(Release release) {
		releaseRepo.save(release);

	}

	@Override
	public List<ReleaseDto> getAllRelease() {
		List<ReleaseDto> releaseDtos = new ArrayList<>();
		List<Release> releases = releaseRepo.findAll();

		for (Release release : releases) {
			ReleaseDto releaseDto = new ReleaseDto();
			BeanUtils.copyProperties(release, releaseDto);
			releaseDtos.add(releaseDto);

		}
		return releaseDtos;
	}

	@Override
	public ReleaseDto getReleaseById(int id) {
		Release release = releaseRepo.findById(id).get();
		ReleaseDto releaseDto = new ReleaseDto();
		BeanUtils.copyProperties(release, releaseDto);

		return releaseDto;
	}

	@Override
	public void updateRelease(Release release) {
		Release exitRelease = releaseRepo.findById(release.getId()).get();
		BeanUtils.copyProperties(release, exitRelease);
		releaseRepo.save(exitRelease);

	}

	@Override
	public void deleteRelease(int id) {
		releaseRepo.deleteById(id);

	}
}
