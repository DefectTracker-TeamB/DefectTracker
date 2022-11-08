package com.spring.gradle.defect.service.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.repository.ModuleRepository;
import com.spring.gradle.defect.service.ModuleService;
import com.spring.gradle.defect.dto.ModuleDto;
import com.spring.gradle.defect.entity.Module;

@Service
public class ModuleServiceImplementation implements ModuleService{

	@Autowired
	ModuleRepository moduleRepository;
	
	@Override
	public void createModule(Module module) {
		moduleRepository.save(module);
		
	}

	@Override
	public List<ModuleDto> getModule() {
		List<ModuleDto> moduleDtos=new ArrayList<>();
		List<Module>modules=moduleRepository.findAll();
		
		for(Module module:modules) {
			ModuleDto moduleDto= new ModuleDto();
			BeanUtils.copyProperties(module, moduleDto);
			moduleDtos.add(moduleDto);
		}
		return moduleDtos;
	}

	@Override
	public ModuleDto getModuleDto(int id) {
		Module module=moduleRepository.findById(id).get();
		ModuleDto moduleDto= new ModuleDto();
		BeanUtils.copyProperties(module, moduleDto);
		return moduleDto;
	}

	@Override
	@Transactional
	public void deleteModule(int id) {
		moduleRepository.deleteById(id);
		
	}

	@Override
	public void updateModule(Module module) {
		Module exitModule=moduleRepository.findById(module.getId()).get();
		BeanUtils.copyProperties(module, exitModule);
		moduleRepository.save(exitModule);
		
	}

}
