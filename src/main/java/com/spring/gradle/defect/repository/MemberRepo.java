package com.spring.gradle.defect.repository;

import com.spring.gradle.defect.entity.TeamMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepo extends JpaRepository<TeamMember, Integer> {
    @Query(value = "select * from team_member where project_id", nativeQuery = true)
    List<TeamMember> getAllByProjectId(int id);
}
