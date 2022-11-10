package com.spring.gradle.defect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gradle.defect.entity.Status;
import com.spring.gradle.defect.service.StatusService;
import com.spring.gradle.defect.util.Constants;

@RestController
public class StatusController {
	@Autowired
	StatusService statusService;
	
	@PostMapping(Constants.STATUS)
	public ResponseEntity<Object>CreateIncomingSample(@RequestBody Status status){
		statusService.saveStatus(status);
		return ResponseEntity.ok("Status Saved Successfully!");
		
	}
	@PutMapping(Constants.PUT_SATATUS)
	public Status updateDefect(@RequestBody Status status) {
		 System.out.println("Successfully update!");
		 statusService.updateStatus(status);
		 return status;
		}
	@GetMapping(Constants.GET_SATATUS)
	public ResponseEntity<Object> getStatusById(@PathVariable Long id) {

		return ResponseEntity.ok(statusService.getStatusById(id));
	}
	
	@DeleteMapping(Constants.DELE_STATUS)
	public ResponseEntity<Object>deleteStatus(@PathVariable Long id){
		statusService.deleteStatus(id);
		return ResponseEntity.ok("Delete Successfully!");
	}
	@GetMapping(Constants.GET_ALLSATATUS)
    public List<Status> getAllStatus() {
        return statusService.getAllStatus();
    }
}
