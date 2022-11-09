package com.spring.gradle.defect.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Project", catalog = "defect_tracker")
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_id")
	private int proId;

	@Column(name = "name")
	private String name;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "description")
	private String description;

	@Column(name = "upload_file")
	private String uploadFile;
	
	@Column(name="project_team")
	private String projectTeam;

	//user
//	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
//	@JoinColumn(name = "id", nullable = false)
//	private List<User> user;

	//module
	@Transient
	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<Module> module;

	public Project() {
		super();
	}


	public Project(int proId, String name, String startDate, String endDate, String description, String uploadFile,
			String projectTeam, List<Module> module) {
		super();
		this.proId = proId;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.uploadFile = uploadFile;
		this.projectTeam = projectTeam;
		this.module = module;
	}

	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	
	//User
//	public List<User> getUser() {
//		return user;
//	}
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}

	
	public String getProjectTeam() {
		return projectTeam;
	}


	public void setProjectTeam(String projectTeam) {
		this.projectTeam = projectTeam;
	}


	//module
	public List<Module> getModule() {
		return module;
	}

	public void setModule(List<Module> module) {
		this.module = module;
	}

	

}