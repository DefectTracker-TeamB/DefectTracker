package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Defect  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String description;
	private String steps_to_recreate;
	private String severity;
	private String priority;
	private String status;
	private String created_on;
	private String assignee;
	private String Assign_to;

	@ManyToOne
	@JsonIgnore
	private Releases release;

	@ManyToOne
	@JsonIgnore
	private Module module;

	@ManyToOne
	@JsonIgnore
	private Project project;



	
	
}
