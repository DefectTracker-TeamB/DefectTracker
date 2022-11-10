package com.spring.gradle.defect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.gradle.defect.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{

	//User save(User user); 
	
} 
