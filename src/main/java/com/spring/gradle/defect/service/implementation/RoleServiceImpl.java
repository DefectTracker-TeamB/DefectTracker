package com.spring.gradle.defect.service.implementation;

import com.spring.gradle.defect.dto.RoleDto;
import com.spring.gradle.defect.entity.Roles;
import com.spring.gradle.defect.repository.RoleRepo;
import com.spring.gradle.defect.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public void createRole(RoleDto roleDto) {
        Roles roles = new Roles();
        roles.setRole_name(roleDto.getRole_name());
        roleRepo.save(roles);
    }

    @Override
    public void deleteRole(int role_id) {
        roleRepo.deleteById(role_id);

    }

    @Override
    public void editRole(int id, RoleDto roleDto) {
        Roles roles = roleRepo.findById(id).get();
        roles.setRole_name(roleDto.getRole_name());
        roleRepo.save(roles);

    }

    @Override
    public List<Roles> getAllRoles() {
        return roleRepo.findAll();
    }
}
