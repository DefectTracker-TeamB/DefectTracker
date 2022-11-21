package com.spring.gradle.defect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReleaseDto {
    private int id;
    private String releaseVersion;
    private String apiLink;
    private String uploadFile;
    private int project_id;


}
