package com.spring.gradle.defect.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"password","teamMembers","userName"})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int emp_id;
	private String name;
	private String username;
	private String password;
	private int availability;
	private String Designation;

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "user",orphanRemoval = true)
	@JsonManagedReference
	private List<TeamMember> teamMembers;




}
