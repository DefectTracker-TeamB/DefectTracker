package com.spring.gradle.defect.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class SmokeTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	private String post_by;


	private String status;

	private String description;
	
	//entity
	@OneToOne(fetch = FetchType.LAZY)

	private Releases releases;
	
	

	
	
	
	
}
