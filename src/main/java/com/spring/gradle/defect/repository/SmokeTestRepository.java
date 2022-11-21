package com.spring.gradle.defect.repository;

import com.spring.gradle.defect.entity.SmokeTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmokeTestRepository extends JpaRepository<SmokeTest, Integer> {


}
