package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Getter
@Setter
public class Project {

	/**
	 *
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "Project name shouldn't be null")
	private String name;

	@NotNull(message = "startDate shouldn't be null")
	private String startDate;

	@NotNull(message = "endDate shouldn't be null")
	private String endDate;

	@NotNull(message = "description shouldn't be null")
	private String description;

	@NotNull(message = "uploadFile shouldn't be null")
	private String uploadFile;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<TeamMember> teamMembers;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Module> modules;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "project")
	@JsonManagedReference
	private List<Releases> releases;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Defect> defects;

}