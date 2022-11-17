package com.spring.gradle.defect.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;
import com.spring.gradle.defect.repository.StatusRepository;
import com.spring.gradle.defect.service.StatusService;

@Service
public class StatusServiceImplementation implements StatusService {

	@Autowired
	StatusRepository statusRepository;

	// create status
	@Override
	public void saveStatus(StatusDto statusDto) {
		Status status = new Status();
		status.setStatus(statusDto.getStatus());
		statusRepository.save(status);// save(statusDto);

	}

	// get all status
	@Override
	public List<StatusDto> getAllStatus() {

		List<StatusDto> statusDtos = new ArrayList<>();
		List<Status> statuses = statusRepository.findAll();

		for (Status status : statuses) {
			StatusDto statusDto = new StatusDto();
			BeanUtils.copyProperties(status, statusDto);
			statusDtos.add(statusDto);
		}
		return statusDtos;

	}

	// get status id
	@Override
	public StatusDto getStatusById(int id) {
		Status status = statusRepository.findById(id).get();
		StatusDto statusDto = new StatusDto();
		BeanUtils.copyProperties(status, statusDto);
		return statusDto;

	}

	// Update status
	@Override
	public void updateStatus(StatusDto statusDto) {
		Status exitStatus = statusRepository.findById(statusDto.getId()).get();// getId()).get();
		BeanUtils.copyProperties(statusDto, exitStatus);
		statusRepository.save(exitStatus);

	}

	@Override
	public void deleteStatus(int id) {
		statusRepository.deleteById(id);

	}

}
