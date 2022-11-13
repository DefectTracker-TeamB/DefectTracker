package com.spring.gradle.defect.entity;

//package com.spring.gradle.defect.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status_data")
@Getter
@Setter
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String status_name;
	private String change_date;
	private String description;



}
