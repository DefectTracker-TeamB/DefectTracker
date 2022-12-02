package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class SmokeTest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull(message = "post_by shouldn't be null")
	private String post_by;

	@NotNull(message = "status shouldn't be null")
	private String status;

	@NotNull(message = "description shouldn't be null")
	private String description;

	// entity
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Releases releases;

}
