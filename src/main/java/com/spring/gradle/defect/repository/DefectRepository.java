package com.spring.gradle.defect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.gradle.defect.entity.Defect;

@Repository
public interface DefectRepository extends JpaRepository<Defect,Integer> {

}
