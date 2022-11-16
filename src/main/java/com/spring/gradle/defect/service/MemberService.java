package com.spring.gradle.defect.service;

import com.spring.gradle.defect.dto.TeamMemberDto;
import com.spring.gradle.defect.entity.TeamMember;

import java.util.List;

public interface MemberService {
    String saveMember(TeamMemberDto teamMemberDto);
    void deleteMember(int id);
    List<TeamMember> getTeamMembers(int id);
    String editMembers(TeamMemberDto teamMemberDto);
}
