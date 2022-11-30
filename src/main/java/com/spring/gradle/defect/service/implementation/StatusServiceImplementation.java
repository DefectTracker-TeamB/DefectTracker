package com.spring.gradle.defect.service.implementation;

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;
import com.spring.gradle.defect.repository.StatusRepository;
import com.spring.gradle.defect.service.StatusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImplementation implements StatusService {

    @Autowired
    StatusRepository statusRepository;

    //create status
    @Override
    public void saveStatus(Status status) {
        statusRepository.save(status);

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

    //get status id
    @Override
    public StatusDto getStatusById(Long id) {
        Status status = statusRepository.findById(id).get();
        StatusDto statusDto = new StatusDto();
        BeanUtils.copyProperties(status, statusDto);
        return statusDto;


    }


    //Update status
    @Override
    public void updateStatus(Status status) {
        Status exitStatus = statusRepository.findById(status.getId()).get();
        BeanUtils.copyProperties(status, exitStatus);
        statusRepository.save(exitStatus);


    }


    // Delete status
    @Override
    public void deleteStatus(Long id) {

        statusRepository.deleteById(id);

    }


}

	
	
	
	

