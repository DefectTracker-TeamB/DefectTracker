package com.spring.gradle.defect.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.entity.User;
import com.spring.gradle.defect.repository.UserRepository;
import com.spring.gradle.defect.service.UserService;

@Service
public class UserImplementation implements UserService{ 
	@Autowired 
	private UserRepository userRepository;
	
	@Override 
	public void saveUser(UserDto userDto) {
		User user=new User();
		user.setEmp_id(userDto.getEmp_id());
		user.setDesignation(userDto.getDesignation());
		user.setAvailability(100);
		user.setName(userDto.getName());
		user.setUsername(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		userRepository.save(user);
	} 
	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	//UPDATE 
	@Override
	public void updateUser(UserDto userDto) {
		User user=userRepository.findById(userDto.getId()).get();
		user.setEmp_id(userDto.getEmp_id());
		user.setDesignation(userDto.getDesignation());
		user.setName(userDto.getName());
		user.setUsername(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		userRepository.save(user);
	}
	//DELETE 
	@Override
	public String deleteUserByEmpId(int emp_id) {
		User user=userRepository.getUserByEmpId(emp_id);
		if(user!=null){
			userRepository.deleteById(user.getId());
			return "user removed";
		}else {
			return "user doesn't exists";
		}
	}
	@Override
	public List<User> getUsersByAvailability() {
		return userRepository.getByAvailability();
	}

	@Override
	public User getUserByEmpId(int emp_id) {
		return userRepository.getUserByEmpId(emp_id);
	}


}
