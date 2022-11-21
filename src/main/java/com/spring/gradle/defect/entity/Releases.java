package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Releases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String api_link;
    private String upload_file;
    private String release_version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Project project;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "releases", cascade = CascadeType.ALL)
    @JsonBackReference
    private SmokeTest smokeTest;

}
