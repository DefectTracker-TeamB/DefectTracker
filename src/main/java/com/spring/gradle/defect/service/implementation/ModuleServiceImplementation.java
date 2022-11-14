package com.spring.gradle.defect.service.implementation;

import java.util.List;

import javax.transaction.Transactional;

import com.spring.gradle.defect.entity.Project;
import com.spring.gradle.defect.entity.TeamMember;
import com.spring.gradle.defect.repository.MemberRepo;
import com.spring.gradle.defect.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.repository.ModuleRepository;
import com.spring.gradle.defect.service.ModuleService;
import com.spring.gradle.defect.dto.ModuleDto;
import com.spring.gradle.defect.entity.Module;

@Service
public class ModuleServiceImplementation implements ModuleService {

	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private MemberRepo memberRepo;
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public void createModule(ModuleDto moduleDto) {
		Module module=new Module();
		TeamMember developer=memberRepo.findById(moduleDto.getDeveloper_Team_id()).orElse(new TeamMember());
		TeamMember tester=memberRepo.findById(moduleDto.getTester_Team_id()).orElse(new TeamMember());
		Project project=projectRepository.findById(moduleDto.getProject_id()).get();
		module.setName(moduleDto.getName());
		module.setAssignedTester(tester.getName());
		module.setAssignedDeveloper(developer.getName());
		module.setDescription(moduleDto.getDescription());
		module.setProject(project);
		moduleRepository.save(module);
	}

	@Override
	public List<Module> getAllModule() {
		return moduleRepository.findAll();
	}

	@Override
	public Module getModuleById(int id) {
		return moduleRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteModule(int id) {
		moduleRepository.deleteById(id);

	}

	@Override
	public void updateModule(ModuleDto moduleDto) {
		Module module=moduleRepository.findById(moduleDto.getId()).orElse(new Module());
		TeamMember developer=memberRepo.findById(moduleDto.getDeveloper_Team_id()).orElse(new TeamMember());
		TeamMember tester=memberRepo.findById(moduleDto.getTester_Team_id()).orElse(new TeamMember());
		module.setName(moduleDto.getName());
		module.setAssignedTester(tester.getName());
		module.setAssignedDeveloper(developer.getName());
		module.setDescription(moduleDto.getDescription());
		moduleRepository.save(module);

	}

}
