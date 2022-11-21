package com.spring.gradle.defect.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private int id;
    private int emp_id;
    private String name;
    private String userName;
    private String password;
    private String designation;
    private List<Integer>role_id;


} 
