package com.spring.gradle.defect.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Project",catalog = "defect_tracker")
public class Project implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pro_id")
	private int proId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="start_date")
	private String startDate;
	
	@Column(name="end_date")
	private String endDate;
	
	@Column(name="description")
	private String description;
	
	@Column(name="upload_file")
	private String uploadFile;

	public Project() {
		super();
	}

	public Project(int proId, String name, String startDate, String endDate, String description, String uploadFile) {
		super();
		this.proId = proId;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.uploadFile = uploadFile;
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

	@Override
	public String toString() {
		return "Project [proId=" + proId + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", description=" + description + ", uploadFile=" + uploadFile + "]";
	}

	
	
	
}
