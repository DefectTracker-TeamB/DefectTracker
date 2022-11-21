package com.spring.gradle.defect.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gradle.defect.dto.StatusWorkFlowDto;
import com.spring.gradle.defect.entity.Status;
import com.spring.gradle.defect.entity.StatusWorkFlow;
import com.spring.gradle.defect.repository.StatusRepository;
import com.spring.gradle.defect.repository.StatusWorkFlowRepo;
import com.spring.gradle.defect.service.StatusWorkFlowService;

@Service
public class StatusWorkFlowServiceImplementation implements StatusWorkFlowService {

	@Autowired
	private StatusWorkFlowRepo statusWorkFlowRepo;

	@Autowired
	private StatusRepository statusRepo;

	@Override
	public void createStatusWorkFlow(StatusWorkFlowDto statusWorkFlowDto) {
		StatusWorkFlow statusWorkFlow = new StatusWorkFlow();
		Status status = statusRepo.findById(statusWorkFlowDto.getId()).get();
		statusWorkFlow.setStatusWorkflow(statusWorkFlowDto.getStatusWorkflow());
		//statusWorkFlow.setStatusWorkflow(null);//setStatusWorkflow(status);
		statusWorkFlow.setStatus(status);
		statusWorkFlowRepo.save(statusWorkFlow);

	}

	@Override
	public List<StatusWorkFlow> getAllStatusWorkFlow() {

		return statusWorkFlowRepo.findAll();
	}

	@Override
	public StatusWorkFlow getStatusWorkFlowById(Long id) {

		return statusWorkFlowRepo.findById(id).get();
	}

	@Override
	public void updateStatusWorkFlow(StatusWorkFlowDto statusWorkFlowDto) {
		StatusWorkFlow statusWorkFlow = statusWorkFlowRepo.findById(statusWorkFlowDto.getId()).get();
		Status status = statusRepo.findById(statusWorkFlowDto.getId()).get();

		statusWorkFlow.setStatusWorkflow(statusWorkFlow.getStatusWorkflow());
		statusWorkFlow.setStatus(status);

		statusWorkFlowRepo.save(statusWorkFlow);

	}

}
