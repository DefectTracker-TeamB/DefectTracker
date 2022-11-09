package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.entity.User;
import com.spring.gradle.defect.service.implementation.List;  

public interface UserService {

	void saveUser(User user);
	void updateUser(User user);
	UserDto getUserDto(Long id);
	void deleteUser(long id);
	java.util.List<UserDto> getUserDtos();
	java.util.List<User> saveUsers(User user);      

}

