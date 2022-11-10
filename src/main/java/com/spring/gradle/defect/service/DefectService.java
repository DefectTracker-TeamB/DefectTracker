package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.entity.Defect;

public interface DefectService {
	
	public void saveDefect(Defect defect);

	public List<DefectDto> getAllDefect();

	public DefectDto getDefectById(Long id);

	public void deleteDefect(Long id);

	public void updateDefect(Defect defect);
}
