package com.spring.gradle.defect.service.implementation;

import com.spring.gradle.defect.dto.DefectDto;
import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Defect;
import com.spring.gradle.defect.entity.Module;
import com.spring.gradle.defect.entity.Notification;
import com.spring.gradle.defect.entity.Project;
import com.spring.gradle.defect.entity.Releases;
import com.spring.gradle.defect.repository.DefectRepository;
import com.spring.gradle.defect.repository.ModuleRepository;
import com.spring.gradle.defect.repository.ProjectRepository;
import com.spring.gradle.defect.repository.ReleaseRepository;
import com.spring.gradle.defect.service.DefectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DefectImplementation implements DefectService {

    @Autowired
    private DefectRepository defectRepository;
    @Autowired  WSService service;
    @Autowired NotificationImplementation MNotificationService;
	final DateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a ");
	static String message1="Assaigned A New Defect To";
	static String message2=" Defect Sucessfully Updated By";
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private ReleaseRepository releaseRepository;
    //create
    @Override
    public void saveDefect(DefectDto defectDto) {
        Defect defect = new Defect();
        Module module = moduleRepository.findById(defectDto.getModule_id()).get();
        Project project = projectRepository.findById(defectDto.getProject_id()).get();
        Releases release = releaseRepository.findById(defectDto.getRelease_id()).get();
        defect.setAssign_to(module.getAssignedDeveloper());
        defect.setAssignee(module.getAssignedTester());
        defect.setDescription(defectDto.getDescription());
        defect.setSeverity(defectDto.getSeverity());
        defect.setPriority(defectDto.getPriority());
        defect.setCreated_on(defectDto.getCreated_on());
        defect.setSteps_to_recreate(defectDto.getSteps_to_recreate());
        defect.setStatus("New");
        defect.setRelease(release);
        defect.setModule(module);
        defect.setProject(project);
        defectRepository.save(defect);
        Notification notific=new Notification();
		notific.setDefect(defect);
		notific.setTo_whome(module.getAssignedDeveloper());
		notific.setContent((DATE_FORMATTER.format(new Date()) + module.getAssignedTester())+" "+message1.toString()+" "+module.getAssignedDeveloper());
		MNotificationService.saveNotific(notific);
        service.notifyFrontend((DATE_FORMATTER.format(new Date()) + module.getAssignedTester())+" "+message1.toString()+" "+module.getAssignedDeveloper());
        //service.notifyUser(notific.getTo_whome(),(DATE_FORMATTER.format(new Date()) + module.getAssignedTester())+" "+message1.toString());
    }

    // get all
    @Override
    public List<Defect> getAllDefect() {
        // TODO Auto-generated method stub
        return defectRepository.findAll();

    }

    // get by id
    @Override
    public Defect getDefectById(int id) {
        return defectRepository.findById(id).get();

    }

    // Delete
    @Override
    public void deleteDefect(int id) {
        defectRepository.deleteById(id);

    }

    //Update
    @Override
    public void updateDefect(DefectDto defectDto) {

        Defect defect = defectRepository.findById(defectDto.getId()).get();
        Module module = moduleRepository.findById(defectDto.getModule_id()).get();
        Project project = projectRepository.findById(defectDto.getProject_id()).get();
        Releases release = releaseRepository.findById(defectDto.getRelease_id()).get();
        defect.setAssign_to(module.getAssignedDeveloper());
        defect.setAssignee(module.getAssignedTester());
        defect.setDescription(defectDto.getDescription());
        defect.setSeverity(defectDto.getSeverity());
        defect.setPriority(defectDto.getPriority());
        defect.setCreated_on(defectDto.getCreated_on());
        defect.setSteps_to_recreate(defectDto.getSteps_to_recreate());
        defect.setRelease(release);
        defect.setModule(module);
        defect.setProject(project);
        defectRepository.save(defect);
        Notification notific=new Notification();
        notific.setDefect(defect);
		notific.setContent((DATE_FORMATTER.format(new Date())+""+message2.toString()+" "+module.getAssignedDeveloper()));
		MNotificationService.saveNotific(notific);
        service.notifyFrontend((DATE_FORMATTER.format(new Date())+""+message2.toString()+" "+module.getAssignedDeveloper()));
        //notifyFrontend
    }

    @Override
    public void setStatus(StatusDto statusDto) {
        Defect defect = defectRepository.findById(statusDto.getDefect_id()).get();
        String status = statusDto.getStatus();
        if (defect.getStatus().contains("New")) {
            if (status.contains("Open")) {
                defect.setStatus(statusDto.getStatus());
            }
        } else if (defect.getStatus().contains("Open")) {
            if (status.contains("Reject") | status.contains("Progress")) {
                defect.setStatus(statusDto.getStatus());
            }

        }
        defect.setStatus(statusDto.getStatus());
        defectRepository.save(defect);
    }


}
