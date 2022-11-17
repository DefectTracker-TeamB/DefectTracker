package com.spring.gradle.defect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.gradle.defect.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

	//void save(StatusDto statusDto);

	
}
