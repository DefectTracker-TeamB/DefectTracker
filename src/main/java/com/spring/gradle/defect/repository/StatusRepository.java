package com.spring.gradle.defect.repository;

import com.spring.gradle.defect.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {

}
