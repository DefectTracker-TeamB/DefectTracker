package com.spring.gradle.defect.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger log = LoggerFactory.getLogger(UserController.class);

	// create user
	@PostMapping("/createUser")
	public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {
		userService.saveUser(userDto);
		log.info("User created");
		log.error("Can not create the user", userDto);
		return ResponseEntity.ok("Added to defect Tracker application");
	}

	@GetMapping("/bench")
	public ResponseEntity<Object> getUsers() {
		log.info("User availability displayed");
		log.error("unable to view the user availability", userService);
		return ResponseEntity.ok(userService.getUsersByAvailability());
	}

	@GetMapping("getuser/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") int id) {
		log.info("User displayed");
		log.error("unable to view the user", userService);
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@PutMapping("/editUser")
	public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto) {
		userService.updateUser(userDto);
		log.info("User updated");
		log.error("unable to update the user", userService);
		return ResponseEntity.ok("User Updated");
	}

	@DeleteMapping("/deleteUser/{emp_id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("emp_id") int id) {
		log.info("User deleted");
		log.error("unable to delete the user", userService);
		return ResponseEntity.ok(userService.deleteUserByEmpId(id));
	}

}

//Login API
