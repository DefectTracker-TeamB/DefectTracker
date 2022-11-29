package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.EmpServiceUserDto;
import com.spring.gradle.defect.dto.RoleAssignDto;
import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//User CRUD
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    
    
	Logger log = LoggerFactory.getLogger(UserController.class);


    // create user
    @PostMapping("/createUser")
    public ResponseEntity<Object> saveUser(@RequestBody EmpServiceUserDto empServiceUserDto) {
        //userService.saveUser(empServiceUserDto);
    	log.info("Entered to user");
        userService.saveUser(empServiceUserDto);
        log.info("Datas sent to user service");
		log.error("Unable to create user", empServiceUserDto);
        return ResponseEntity.ok("Added to defect Tracker application");
    }


    @GetMapping("/bench")
    public ResponseEntity<Object> getUsers() {
    	log.info("Entered to user");
		log.info("Datas displayed from user database");
		log.error("Can not to view the user details", userService);
        return ResponseEntity.ok(userService.getUsersByAvailability());
    }

    @GetMapping("getuser/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") int id) {
    	log.info("Entered to user");
		log.info("Data displayed from user database");
		log.error("Can not to view the user detail", userService);
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/editUser")
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto) {
       // userService.updateUser(userDto);
    	log.info("Entered to user");
    	userService.updateUser(userDto);
    	log.info("Datas update from user service");
		log.error("Can not to update the user detail", userService);
        return ResponseEntity.ok("User Updated");
    }

    @DeleteMapping("/deleteUser/{emp_id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("emp_id") int id) {
    	log.info("Entered to user");
    	log.info("Datas delete from user service");
    	log.error("Can not to delete the user detail", userService);
        return ResponseEntity.ok(userService.deleteUserByEmpId(id));
    }
    @PutMapping("/addRoles")
    public ResponseEntity<Object> addRoles(@RequestBody RoleAssignDto roleAssignDto) {
    	log.info("Entered to user role");
        userService.setRoles(roleAssignDto);
        log.info("Datas sent to user service");
        log.error("Unable to create user role", userService);
        return ResponseEntity.ok("Roles assigned");
    }

}


//Login API

	

