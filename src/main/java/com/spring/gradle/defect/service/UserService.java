package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.entity.User;  

public interface UserService {

	void saveUser(UserDto userDto);
	void updateUser(UserDto userDto);
	User getUserById(int id);
	String deleteUserByEmpId(int emp_id);
	List<User> getUsersByAvailability();

	User getUserByEmpId(int emp_id);

}

