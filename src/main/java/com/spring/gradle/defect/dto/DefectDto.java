package com.spring.gradle.defect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefectDto {
    private int id;
    private String description;
    private String steps_to_recreate;
    private String severity;
    private String priority;
    private String created_on;
    private int module_id;
    private int release_id;
    private int project_id;

}
