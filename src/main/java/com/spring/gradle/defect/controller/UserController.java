package com.spring.gradle.defect.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

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
	
	Logger log = LoggerFactory.getLogger(DefectController.class);
	
	// create user 
    @PostMapping("/createUser")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {
    	log.info("Entered to user");
        userService.saveUser(userDto);
        log.info("Datas sent to user service");
		log.error("Unable to create user", userDto);
	    return ResponseEntity.ok("Added to defect Tracker application");
   } 


//	// create user
//	@PostMapping("/createUser")
//	public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {
//		userService.saveUser(userDto);
//		log.info("User created");
//		log.error("Can not create the user", userDto);
//		return ResponseEntity.ok("Added to defect Tracker application");
//	}

	@GetMapping("/bench")
	public ResponseEntity<Object> getUsers() {

		log.info("Entered to user");
		log.info("Datas displayed from user database");
		log.error("Can not to view the user details", userService);
		return ResponseEntity.ok(userService.getUsersByAvailability());
	}

    @GetMapping("getuser/{id}")
    public ResponseEntity<Object> getUser(@PathVariable("id") int id){
    	log.info("Entered to user");
		log.info("Data displayed from user database");
		log.error("Can not to view the user detail", userService);
		return ResponseEntity.ok(userService.getUserById(id));
    } 
    @PutMapping("/editUser")
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto){
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

}























//	@DeleteMapping("/deleteUser/{emp_id}")
//	public ResponseEntity<Object> deleteUser(@PathVariable("emp_id") int id) {
//		log.info("User deleted");
//		log.error("unable to delete the user", userService);
//		return ResponseEntity.ok(userService.deleteUserByEmpId(id));
//	}
//
//}
//
////Login API
