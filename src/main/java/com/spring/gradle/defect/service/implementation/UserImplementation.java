package com.spring.gradle.defect.service.implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.gradle.defect.dto.UserDto;
import com.spring.gradle.defect.entity.User;
import com.spring.gradle.defect.repository.UserRepository;
import com.spring.gradle.defect.service.UserService;

@Service
public class UserImplementation implements UserService{ 
	@Autowired 
	UserRepository userRepository; 
	
	@Override 
	public void saveUser(User user) {
		userRepository.save(user); 
	} 
	@Override
	public UserDto getUserDto(Long id) { 
		User user = userRepository.findById(id).get();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto; 
	}
	//UPDATE 
	@Override
	public void updateUser(User user) {
		User existingUser = userRepository.findById(user.getId()).get();
		BeanUtils.copyProperties(user, existingUser);
		userRepository.save(existingUser);
	}
	//DELETE 
	@Override 
	@Transactional
	public void deleteUser(long id) {
		userRepository.deleteById(id);
	} 
	
//	@Override 
//	public List<UserDto>  getUserDtos() {
//		List<UserDto> userDtos = new ArrayList<>();
//		List<User> users = userRepository.findAll();
//		
//		for(User user:users) {
//			UserDto userDto = new UserDto();
//			BeanUtils.copyProperties(user, userDto);
//			userDtos.add(userDto);
//		}
//		return userDtos; 
//	}
//	
	
	
	
	

}
