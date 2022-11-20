package com.spring.gradle.defect.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleAssignDto {
    private int user_id;
    private List<Integer> role_id;
}
