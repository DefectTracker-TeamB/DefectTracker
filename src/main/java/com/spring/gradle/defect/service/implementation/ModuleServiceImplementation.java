package com.spring.gradle.defect.service.implementation;

import com.spring.gradle.defect.dto.ModuleDto;
import com.spring.gradle.defect.entity.Module;
import com.spring.gradle.defect.entity.Project;
import com.spring.gradle.defect.entity.TeamMember;
import com.spring.gradle.defect.repository.MemberRepo;
import com.spring.gradle.defect.repository.ModuleRepository;
import com.spring.gradle.defect.repository.ProjectRepository;
import com.spring.gradle.defect.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ModuleServiceImplementation implements ModuleService {

	   @Autowired  WSService service;
	
	    @Autowired NotificationImplementation MNotificationService;
		final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a ");
		static String message1="Module created by";
		static String message2=" Module Sucessfully Updated By";
	   
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createModule(ModuleDto moduleDto) {
        Module module = new Module();
        TeamMember developer = memberRepo.findById(moduleDto.getDeveloper_Team_id()).get();
        TeamMember tester = memberRepo.findById(moduleDto.getTester_Team_id()).get();
        Project project = projectRepository.findById(moduleDto.getProject_id()).get();
        module.setName(moduleDto.getName());
        module.setAssignedTester(tester.getName());
        module.setAssignedDeveloper(developer.getName());
        module.setDescription(moduleDto.getDescription());
        module.setProject(project);
        moduleRepository.save(module);
        
//        Notification notific=new Notification();
//        notific.setModule(module);
//        notific.setMessage((DATE_FORMATTER.format(new Date()) +" "+message1.toString()+" "+module.getAssignedDeveloper()));
//        MNotificationService.saveNotific(notific);
//        service.notifyFrontend((DATE_FORMATTER.format(new Date()) +" "+message1.toString()+" "+module.getAssignedDeveloper()));
//        
		//notific.se//setDefect(defect);
	//	notific.//setMessage((DATE_FORMATTER.format(new Date()) + module.getAssignedTester())+" "+message1.toString()+" "+module.getAssignedTester());
		//MNotificationService.saveNotific(notific);
        //service.notifyFrontend((DATE_FORMATTER.format(new Date()) + module.getAssignedTester())+" "+message1.toString()+" "+module.getAssignedTester());
        
        
        
        
        
        
        
        
        
        
        
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
        Module module = moduleRepository.findById(moduleDto.getId()).get();
        TeamMember developer = memberRepo.findById(moduleDto.getDeveloper_Team_id()).get();
        TeamMember tester = memberRepo.findById(moduleDto.getTester_Team_id()).get();
        module.setName(moduleDto.getName());
        module.setAssignedTester(tester.getName());
        module.setAssignedDeveloper(developer.getName());
        module.setDescription(moduleDto.getDescription());
        moduleRepository.save(module);

    }

}
