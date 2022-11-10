package com.spring.gradle.defect.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "defect_data")
public class Defect implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String steps_to_recreate;
	private String severity;
	private String priority;
	private String status;
	private String created_on;
	private String assignee;
	private String Assign_to;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSteps_to_recreate() {
		return steps_to_recreate;
	}

	public void setSteps_to_recreate(String steps_to_recreate) {
		this.steps_to_recreate = steps_to_recreate;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getAssign_to() {
		return Assign_to;
	}

	public void setAssign_to(String assign_to) {
		Assign_to = assign_to;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Defect() {
		super();
	}

	public Defect(Long id, String description, String steps_to_recreate, String severity, String priority,
			String status, String created_on, String assignee, String assign_to) {
		super();
		this.id = id;
		this.description = description;
		this.steps_to_recreate = steps_to_recreate;
		this.severity = severity;
		this.priority = priority;
		this.status = status;
		this.created_on = created_on;
		this.assignee = assignee;
		Assign_to = assign_to;
	}
//Mapping
	
//	@ManyToOne(targetEntity = Module.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "id",nullable =false)
//    private List<Module> module;
	
	
	
//	@ManyToOne(targetEntity = TeamMember.class,fetch = FetchType.EAGER)
//    @JoinColumn(name = "id",nullable =false)
    //private List<TeamMember> teamMember;
	
//Mapping
	
//	public List<TeamMember> getTeamMember() {
//		return teamMember;
//	}
//	public void setTeamMember(List<TeamMember> teamMember) {
//		this.teamMember = teamMember;
//	}
	
	
//	public List<Module> getModule() {
//		return module;
//	}
//	public void setModule(List<Module> module) {
//		this.module = module;
//	}
//	
	
	
	//mapping
		//private Module module;
		
		//private TeamMember teamMember;
	



	
	
}
