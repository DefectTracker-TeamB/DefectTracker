package com.spring.gradle.defect.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.entity.Defect;
import com.spring.gradle.defect.repository.DefectRepository;
import com.spring.gradle.defect.service.DefectService;

@Service
public class DefectImplementation implements DefectService  {
	
	@Autowired
	DefectRepository defectRepository;

//create
	@Override
	public void saveDefect(Defect defect) {
		defectRepository.save(defect);

	}

	// get all
	@Override
	public List<DefectDto> getAllDefect() {
		// TODO Auto-generated method stub

		List<DefectDto> defectDtos = new ArrayList<>();
		List<Defect> defects = defectRepository.findAll();

		for (Defect defect : defects) {
			DefectDto defectDto = new DefectDto();
			BeanUtils.copyProperties(defect, defectDto);
			defectDtos.add(defectDto);
		}
		return defectDtos;

	}
	
	// get by id
	@Override
	public DefectDto getDefectById(Long id) {

		Defect defect = defectRepository.findById(id).get();
		DefectDto defectDto = new DefectDto();
		BeanUtils.copyProperties(defect, defectDto);
		return defectDto;

	}

	// Delete
	@Override
	public void deleteDefect(Long id) {
		defectRepository.deleteById(id);

	}
	
	//Update
	@Override
	public void updateDefect(Defect defect) {

		Defect exitDefect = defectRepository.findById(defect.getId()).get();
		BeanUtils.copyProperties(defect, exitDefect);
		defectRepository.save(exitDefect);

	}


}
