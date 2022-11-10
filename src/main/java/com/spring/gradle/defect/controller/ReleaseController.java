package com.spring.gradle.defect.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gradle.defect.dto.ReleaseDto;
import com.spring.gradle.defect.entity.Release;
import com.spring.gradle.defect.service.ReleaseService;
import com.spring.gradle.defect.util.*;


@RestController
@RequestMapping("/release")
public class ReleaseController {
	
	@Autowired
	private ReleaseService releaseService;
	
	//Create
	@PostMapping(Constants.CREATERELEASE)
	public ResponseEntity<Object> createRelease(@RequestBody ReleaseDto releaseDto){
		Release release=new Release();
		BeanUtils.copyProperties(releaseDto, release);
		releaseService.cretaeRelease(release);
		return ResponseEntity.ok(release);
		
		
		
	}
	
	//Get All
	@GetMapping(Constants.GETALLRELEASE)
	public ResponseEntity<Object> getRelease() {
		List<ReleaseDto> releaseDtos =releaseService.getAllRelease();
		return ResponseEntity.ok(releaseDtos);
	}
	
	
	//Get by id
	@GetMapping(Constants.GETBYRELEASEID)
	public ResponseEntity<Object> getRelease(@PathVariable int id) {
		ReleaseDto releaseDto = releaseService.getReleaseById(id);
		return ResponseEntity.ok(releaseDto);
	}
	//Delete
@DeleteMapping(Constants.DELETERELEASE)
public ResponseEntity<Object> deleteRelease(@PathVariable int id) {
	releaseService.deleteRelease(id);
	return ResponseEntity.ok(id);
}

//Update
	@PutMapping(Constants.UPDATERELEASE) // ("/update")
	public ResponseEntity<Object> updateRelease(@RequestBody ReleaseDto releaseDto) {
		Release release = new Release();
		BeanUtils.copyProperties(releaseDto, release);
		releaseService.updateRelease(release);
		return ResponseEntity.ok(release);
	}
}
