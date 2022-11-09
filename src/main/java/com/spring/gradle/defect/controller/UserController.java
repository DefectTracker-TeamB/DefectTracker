package com.spring.gradle.defect.controller;

import java.util.List;

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
import com.spring.gradle.defect.entity.User;
import com.spring.gradle.defect.service.UserService;

                 //User CRUD 
@RestController 
public class UserController { 
	@Autowired
    private UserService userService;
	
	// create user 
    @PostMapping("/createuser")
    public ResponseEntity<Object> saveUser(@RequestBody UserDto userDto) {
    User user = new User(); 
    BeanUtils.copyProperties(userDto,user );
    userService.saveUser(user);
	return ResponseEntity.ok(user);
   } 
    
    
    
    // GET ALL USERS 
    @GetMapping("users")
    public ResponseEntity<Object> getUsers() {
    	List<UserDto> userDtos = userService.getUserDtos();
    	return ResponseEntity.ok(userDtos);
    }
    @GetMapping("user/{id}")
    public ResponseEntity<Object> getUser(@PathVariable Long id){
    	UserDto userDto = userService.getUserDto(id);
    	return ResponseEntity.ok(userDto);
    } 
    @PutMapping("/user/{id}") 
    public ResponseEntity<Object> updateUser(@RequestBody UserDto userDto){
    	User user = new User();
    	BeanUtils.copyProperties(userDto,user );
    	userService.saveUser(user);
    	return ResponseEntity.ok(user);
    } 
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id) {
    	userService.deleteUser(id);
    	return ResponseEntity.ok(id);
    }
    
    
} 























//Login API

	

