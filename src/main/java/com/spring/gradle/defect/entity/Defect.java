package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties({ "" })

@Entity
@Getter
@Setter
public class Defect {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "description shouldn't be null")
	private String description;

	@NotNull(message = "steps_to_recreate shouldn't be null")
	private String steps_to_recreate;

	@NotNull(message = "severity shouldn't be null")
	private String severity;

	@NotNull(message = "priority shouldn't be null")
	private String priority;

	@NotNull(message = "status shouldn't be null")
	private String status;

	@NotNull(message = "created_on shouldn't be null")
	private String created_on;

	@NotNull(message = "assignee shouldn't be null")
	private String assignee;

	@NotNull(message = "Assign_to shouldn't be null")
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

	@OneToMany(mappedBy = "defect", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Notification> notification = new ArrayList<>();

}
