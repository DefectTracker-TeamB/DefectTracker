package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "module")
@Getter
@Setter
public class Module {
	
	/**
	 * 
	 */




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	

	private String name;
	

	private String assignedDeveloper;

	private String assignedTester;
	

	private String description;

	
	@ManyToOne(targetEntity = Project.class,fetch = FetchType.LAZY)
	@JsonBackReference
    private Project project;

    @OneToMany(mappedBy = "module",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
    private List<Defect>defects;



	 


	
	

}
