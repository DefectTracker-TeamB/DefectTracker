package com.spring.gradle.defect.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.dto.StatusDto;
import com.spring.gradle.defect.entity.Status;
import com.spring.gradle.defect.repository.StatusRepository;
import com.spring.gradle.defect.service.StatusService;

@Service
public class StatusImplementation implements StatusService {
	@Autowired
	StatusRepository statusRepository;
	@Override
	public void saveStatus(Status status) {
		statusRepository.save(status);
		}

	@Override
	public StatusDto getStatusById(Long id) {
		
		Status status=statusRepository.findById(id).get();
		StatusDto statusDto=new StatusDto();
		statusDto.setId(status.getId());
		statusDto.setStatus_name(status.getStatus_name());
		statusDto.setChange_date(status.getChange_date());
		statusDto.setDefect_id(status.getDefect_id());
		statusDto.setUser_id(status.getUser_id());
		
		return statusDto;
		
	}
	@Override
	public Status updateStatus(Status status) {
		return statusRepository.save(status);
	}
	
	@Override
	public void deleteStatus(Long id) {
		statusRepository.deleteById(id);
		}
	@Override
    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }
}
