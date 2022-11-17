package com.spring.gradle.defect.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import com.spring.gradle.defect.entity.Status;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "status_workflow")
@Getter
@Setter
public class StatusWorkFlow {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Status status;

	@OneToMany
	@JoinColumn(name = "status_workflow_Id")
	private List<Status> statusWorkflow;

	public void setStatus(Status status2) {
		// TODO Auto-generated method stub
		
	}

}
