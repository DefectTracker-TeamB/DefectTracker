package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.RoleDto;
import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;


    @PostMapping("/createRole")
    public ResponseEntity<Object> createRole(@RequestBody RoleDto roleDto) {
        roleService.createRole(roleDto);
        return ResponseEntity.ok("Role Created");
    }

    @GetMapping("/getAllRoles")
    public ResponseEntity<Object> getRoles() {

        return ResponseEntity.ok(roleService.getAllRoles());
    }
    @PutMapping("/editRole/{id}")
    public ResponseEntity<Object> editRole(@RequestBody RoleDto roleDto,@PathVariable("id") int id) {
        roleService.editRole(id,roleDto);
        return ResponseEntity.ok("Role Edited");
    }
    @DeleteMapping("/deleteRole/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable("id") int id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok("Role deleted");
    }


}
