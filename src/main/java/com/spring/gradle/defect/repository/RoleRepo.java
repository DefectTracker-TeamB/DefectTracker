package com.spring.gradle.defect.repository;

import com.spring.gradle.defect.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Roles, Integer> {
    @Query(value = "select * role_name from roles where role_id=?",nativeQuery = true)
    public String getRoleName(int id);



}
