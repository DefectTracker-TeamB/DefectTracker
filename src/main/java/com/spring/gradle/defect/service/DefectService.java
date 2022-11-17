package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Defect;

public interface DefectService {
	
	public void saveDefect(DefectDto defectDto);

	public List<Defect> getAllDefect();

	public Defect getDefectById(int id);

	public void deleteDefect(int id);

	public void updateDefect(DefectDto defectDto);

	//public void setStatus(StatusDto statusDto);
}
