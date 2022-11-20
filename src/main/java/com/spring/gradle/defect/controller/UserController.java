package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.EmpServiceUserDto;
import com.spring.gradle.defect.dto.RoleAssignDto;
import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//User CRUD
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    // create user
    @PostMapping("/createUser")
    public ResponseEntity<Object> saveUser(@RequestBody EmpServiceUserDto empServiceUserDto) {
        userService.saveUser(empServiceUserDto);
        return ResponseEntity.ok("Added to defect Tracker application");
    }


    @GetMapping("/bench")
    public ResponseEntity<Object> getUsers() {
        return ResponseEntity.ok(userService.getUsersByAvailability());
    }

    @GetMapping("getuser/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") int id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/editUser")
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
        return ResponseEntity.ok("User Updated");
    }

    @DeleteMapping("/deleteUser/{emp_id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("emp_id") int id) {
        return ResponseEntity.ok(userService.deleteUserByEmpId(id));
    }
    @PutMapping("/addRoles")
    public ResponseEntity<Object> addRoles(@RequestBody RoleAssignDto roleAssignDto) {
        userService.setRoles(roleAssignDto);
        return ResponseEntity.ok("Roles assigned");
    }

}


//Login API

	

