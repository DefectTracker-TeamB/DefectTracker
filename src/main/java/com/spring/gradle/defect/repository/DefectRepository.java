package com.spring.gradle.defect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.gradle.defect.entity.Defect;

public interface DefectRepository extends JpaRepository<Defect, Long>{

}
