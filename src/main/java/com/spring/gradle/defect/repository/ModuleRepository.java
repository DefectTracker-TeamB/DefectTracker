package com.spring.gradle.defect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.gradle.defect.entity.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer>{

	//@SuppressWarnings("unchecked")
	//Module save(Module module);


}
