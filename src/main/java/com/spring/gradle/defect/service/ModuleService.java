package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.ModuleDto;
import com.spring.gradle.defect.entity.Module;

import java.util.List;

public interface ModuleService {
    void createModule(ModuleDto moduleDto);

    List<Module> getAllModule();

    Module getModuleById(int id);

    void deleteModule(int id);

    void updateModule(ModuleDto moduleDto);

}
