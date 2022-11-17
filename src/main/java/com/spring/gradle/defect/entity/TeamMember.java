package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"project"})
public class TeamMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String role;
    private int contribution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Project project;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;




}
