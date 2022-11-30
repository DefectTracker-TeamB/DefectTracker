package com.spring.gradle.defect.entity;

//package com.spring.gradle.defect.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private String status_name;
    private String change_date;
    private String description;


}
