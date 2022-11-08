package com.spring.gradle.defect.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "module",catalog = "defect_tracker")
public class Module implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="assignedDeveloper")
	private String assignedDeveloper;
	
	@Column(name="description")
	private String description;

	public Module() {
		super();
	}

	public Module(int id, String name, String assignedDeveloper, String description) {
		super();
		this.id = id;
		this.name = name;
		this.assignedDeveloper = assignedDeveloper;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssignedDeveloper() {
		return assignedDeveloper;
	}

	public void setAssignedDeveloper(String assignedDeveloper) {
		this.assignedDeveloper = assignedDeveloper;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
