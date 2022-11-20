package com.spring.gradle.defect.repository;

import com.spring.gradle.defect.entity.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectRepository extends JpaRepository<Defect, Integer> {

}
