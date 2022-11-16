package com.spring.gradle.defect.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamMemberDto {
    private int id;
    private int project_id;
    private int user_id;
    private String role;
    private int contribution;

}
