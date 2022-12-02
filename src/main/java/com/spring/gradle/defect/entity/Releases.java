package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Releases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@NotNull(message = "api_link shouldn't be null")
    private String api_link;
	
	@NotNull(message = "upload_file shouldn't be null")
    private String upload_file;
	
	@NotNull(message = "release_version shouldn't be null")
    private String release_version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Project project;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "releases", cascade = CascadeType.ALL)
    @JsonBackReference
    private SmokeTest smokeTest;

}
