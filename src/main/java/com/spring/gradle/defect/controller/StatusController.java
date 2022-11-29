package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;
import com.spring.gradle.defect.service.StatusService;
import com.spring.gradle.defect.util.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/status")
@RestController
public class StatusController {
    @Autowired
    StatusService statusService;

    
	Logger log = LoggerFactory.getLogger(StatusController.class);

    
    // Create
    @PostMapping(Constants.CREATESTATUS)
    public ResponseEntity<Object> createStatus(@RequestBody StatusDto statusDto) {
    	log.info("Entered to status");
    	Status status = new Status();
        BeanUtils.copyProperties(statusDto, status);
        statusService.saveStatus(status);
        log.info("Datas sent to status service");
		log.error("Unable to create status", statusDto);
        return ResponseEntity.ok(" Status Successfully created!");

    }

    // Get all
    @GetMapping(Constants.GET_ALLSATATUS)
    public ResponseEntity<Object> getStatus() {
       // List<StatusDto> statusDtos = statusService.getAllStatus();
        log.info("Entered to status");
		List<StatusDto> statusDtos = statusService.getAllStatus();

		log.info("Datas displayed from status database");
		log.error("Can not to view the status details", statusService);
        return ResponseEntity.ok(statusDtos);
    }

    // Get Status
    @GetMapping(Constants.GET_SATATUS)
    public ResponseEntity<Object> getStatusById(@PathVariable int id) {
    	log.info("Entered to status");
		log.info("Data displayed from status database");
		log.error("Can not to view the status detail", statusService);
        return ResponseEntity.ok(statusService.getStatusById(id));
    }

    // update
    @PutMapping(Constants.PUT_SATATUS)
    public Status updateStatus(@RequestBody Status status) {
    	log.info("Entered to status");
        System.out.println("Successfully update!");
        statusService.updateStatus(status);
        log.info("Datas update from status service");
		log.error("Can not to update the status detail", statusService);
        return status;
    }

    // Delete
    @DeleteMapping(Constants.DELE_STATUS)
    public ResponseEntity<Object> deleteStatus(@PathVariable int id) {
     //   statusService.deleteStatus(id);
    	log.info("Entered to status");
		statusService.deleteStatus(id);
		log.info("Datas delete from status service");
		log.error("Can not to delete the status detail", statusService);
        return ResponseEntity.ok("Delete Successfully!");
    }
}
