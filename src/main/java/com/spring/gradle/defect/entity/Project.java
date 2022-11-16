package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Getter
@Setter
public class Project  {

	/**
	 * 
	 */


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String name;


	private String startDate;


	private String endDate;


	private String description;


	private String uploadFile;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TeamMember> teamMembers;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Module> modules;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "project")
	@JsonManagedReference
	private List<Releases> releases;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "project",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Defect> defects;
	



	

	

}