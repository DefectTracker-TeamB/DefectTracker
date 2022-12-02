package com.spring.gradle.defect.entity;

//package com.spring.gradle.defect.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "status_data")
@Getter
@Setter
public class Status implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull(message = "status_name shouldn't be null")
    private String status_name;
    
    @NotNull(message = "change_date shouldn't be null")
    private String change_date;
    
    @NotNull(message = "description shouldn't be null")
    private String description;


}
