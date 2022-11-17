package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.StatusWorkFlowDto;
import com.spring.gradle.defect.entity.StatusWorkFlow;

public interface StatusWorkFlowService {
	void createStatusWorkFlow(StatusWorkFlowDto statusWorkFlowDto);

	List<StatusWorkFlow> getAllStatusWorkFlow();

	StatusWorkFlow getStatusWorkFlowById(int id);

	void updateStatusWorkFlow(StatusWorkFlowDto statusWorkFlowDto);

}
