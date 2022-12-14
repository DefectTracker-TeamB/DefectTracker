package com.spring.gradle.defect.service.implementation;

import com.spring.gradle.defect.dto.TeamMemberDto;
import com.spring.gradle.defect.entity.Project;
import com.spring.gradle.defect.entity.TeamMember;
import com.spring.gradle.defect.entity.User;
import com.spring.gradle.defect.repository.MemberRepo;
import com.spring.gradle.defect.repository.ProjectRepository;
import com.spring.gradle.defect.repository.UserRepository;
import com.spring.gradle.defect.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberImplementation implements MemberService {
    @Autowired
    private MemberRepo memberRepo;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;




    @Override
    public String saveMember(TeamMemberDto teamMemberDto) {
        TeamMember teamMember = new TeamMember();
        Project project = projectRepository.findById(teamMemberDto.getProject_id()).get();
        User user = userRepository.findById(teamMemberDto.getUser_id()).get();
        teamMember.setName(user.getName());
        teamMember.setContribution(teamMemberDto.getContribution());
        teamMember.setRole(teamMemberDto.getRole());
        teamMember.setUser(user);
        teamMember.setProject(project);
        if (user.getAvailability() - teamMemberDto.getContribution() < 0) {
            return "Contribution>availability-> cannot assigned";

        } else {
            String message="You are added to the"+project.getName()+"Project as a "+teamMemberDto.getRole();
            List<String>user_message=new ArrayList<>();
            user.setAvailability(user.getAvailability() - teamMemberDto.getContribution());
            userRepository.save(user);
            memberRepo.save(teamMember);
            user_message.add(user.getUsername());
            user_message.add(message);
            return "added to project";
        }
    }

    @Override
    public void deleteMember(int id) {
        TeamMember teamMember = memberRepo.findById(id).orElse(new TeamMember());
        memberRepo.deleteById(id);
        User user = userRepository.findById(teamMember.getUser().getId()).get();
        user.setAvailability(user.getAvailability() + teamMember.getContribution());
        userRepository.save(user);


    }

    @Override
    public List<TeamMember> getTeamMembers(int project_id) {
        return memberRepo.getAllByProjectId(project_id);
    }

    @Override
    public String editMembers(TeamMemberDto teamMemberDto) {
        TeamMember teamMember = memberRepo.findById(teamMemberDto.getId()).get();
        Project project = projectRepository.findById(teamMemberDto.getProject_id()).get();
        User user = userRepository.findById(teamMemberDto.getUser_id()).get();
        user.setAvailability(user.getAvailability() + teamMember.getContribution());
        teamMember.setName(user.getName());
        teamMember.setContribution(teamMemberDto.getContribution());
        teamMember.setRole(teamMemberDto.getRole());
        teamMember.setUser(user);
        teamMember.setProject(project);
        if (user.getAvailability() - teamMemberDto.getContribution() < 0) {
            return "Contribution>availability-> cannot assigned";

        } else {
            user.setAvailability(user.getAvailability() - teamMemberDto.getContribution());
            userRepository.save(user);
            memberRepo.save(teamMember);
            return "edited successfully";
        }


    }
}
