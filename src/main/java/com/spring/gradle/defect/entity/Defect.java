package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Defect {

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
    
    @OneToMany(mappedBy = "defect",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
	private List<Notification> notification=new ArrayList<>();	


}
