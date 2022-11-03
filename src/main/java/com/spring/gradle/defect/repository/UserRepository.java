package com.spring.gradle.defect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.gradle.defect.entity.User;

public interface UserRepository extends JpaRepository <User, Long>{

	User save(User user); 
	
} 
