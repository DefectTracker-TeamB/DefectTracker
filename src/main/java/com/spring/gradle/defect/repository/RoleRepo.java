package com.spring.gradle.defect.repository;

import com.spring.gradle.defect.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {

}
