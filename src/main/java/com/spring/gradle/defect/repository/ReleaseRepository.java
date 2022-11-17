package com.spring.gradle.defect.repository;

import com.spring.gradle.defect.entity.Releases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReleaseRepository extends JpaRepository<Releases,Integer> {
}
