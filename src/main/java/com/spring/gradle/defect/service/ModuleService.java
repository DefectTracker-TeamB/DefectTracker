package com.spring.gradle.defect.service;

import java.util.List;
import com.spring.gradle.defect.entity.Module;

import com.spring.gradle.defect.dto.ModuleDto;

public interface ModuleService {
	public void createModule(Module module);
	public List<ModuleDto>getModule();
	public ModuleDto getModuleDto(int id);
	public void deleteModule(int id);
	public void updateModule(Module module);

}
