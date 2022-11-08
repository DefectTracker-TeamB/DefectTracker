package com.spring.gradle.defect.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.entity.Defect;
import com.spring.gradle.defect.repository.DefectRepository;
import com.spring.gradle.defect.service.DefectService;

@Service
public class DefectImplementation implements DefectService {
	@Autowired
	DefectRepository defectRepository;
	@Override
	public void saveDefect(Defect defect) {
		defectRepository.save(defect);
		}
	@Override
	public DefectDto getDefectById(Long id) {
		
		Defect defect=defectRepository.findById(id).get();
		DefectDto defectDto=new DefectDto();
		defectDto.setId(defect.getId());
		defectDto.setDescription(defect.getDescription());
		defectDto.setModule(defect.getModule());
		defectDto.setFound_in(defect.getFound_in());
		defectDto.setFixed_in(defect.getFixed_in());
		defectDto.setType(defect.getType());
		defectDto.setPriority(defect.getSeverity());
		defectDto.setPriority(defect.getPriority());
		defectDto.setAssign_to(defect.getAssign_to());
		
		return defectDto;
		
	}
	@Override
	public Defect updateDefect(Defect defect) {
		return defectRepository.save(defect);
	}
	@Override
	public void deleteDefect(Long id) {
		defectRepository.deleteById(id);
		}
	
	

}
