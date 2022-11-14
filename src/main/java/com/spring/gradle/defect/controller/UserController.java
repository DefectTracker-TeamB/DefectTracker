package com.spring.gradle.defect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.service.UserService;

                 //User CRUD 
@RequestMapping("/user")
@RestController 
public class UserController { 
	@Autowired
    private UserService userService;
	
	// create user 
    @PostMapping("/createUser")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
	    return ResponseEntity.ok("Added to defect Tracker application");
   } 


	@GetMapping("/bench")
	public ResponseEntity<Object> getUsers() {
		return ResponseEntity.ok(userService.getUsersByAvailability());
	}

    @GetMapping("getuser/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") int id){
		return ResponseEntity.ok(userService.getUserById(id));
    } 
    @PutMapping("/editUser")
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto){
		userService.updateUser(userDto);
		return ResponseEntity.ok("User Updated");
    } 
    @DeleteMapping("/deleteUser/{emp_id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("emp_id") int id) {
        return ResponseEntity.ok(userService.deleteUserByEmpId(id));
    }

}
























//Login API

	

