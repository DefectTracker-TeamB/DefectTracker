package com.spring.gradle.defect.service;

import java.util.List;

import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.entity.User;  

public interface UserService {

	void saveUser(User user);
	void updateUser(User user);
	UserDto getUserDto(Long id);
	void deleteUser(long id);
	List<UserDto> getUsers();
	
	
	/*
	 **public void createModule(Module module);

	public List<UserDto> getUsers();

	public ModuleDto getModuleDto(int id);

	public void deleteModule(int id);

	//*public void updateModule(Module module);
	 * 
	 * 
	 * 
	 */
//	java.util.List<UserDto> getUserDtos();
//	java.util.List<User> saveUsers(User user);      

}

