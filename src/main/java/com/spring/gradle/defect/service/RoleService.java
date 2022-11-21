package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.RoleDto;
import com.spring.gradle.defect.entity.Roles;

import java.util.List;

public interface RoleService {
    void createRole(RoleDto roleDto);

    void deleteRole(int role_id);

    void editRole(int id, RoleDto roleDto);
    List<Roles>getAllRoles();
}
