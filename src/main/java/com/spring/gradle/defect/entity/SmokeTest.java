package com.spring.gradle.defect.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    @JsonIgnore
    private Releases releases;


}
