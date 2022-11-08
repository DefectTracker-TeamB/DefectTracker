package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.entity.Defect;

public interface DefectService {
	
	void saveDefect(Defect defect);
	Defect updateDefect(Defect defect);
	void deleteDefect(Long id);
	DefectDto getDefectById(Long id);
	

}
