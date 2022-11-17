package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.TeamMemberDto;
import com.spring.gradle.defect.service.MemberService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class TeamMemberController {
    @Autowired
    private MemberService memberService;
    
    
	Logger log = LoggerFactory.getLogger(TeamMemberController.class);


    @PostMapping("/addMember")
    public ResponseEntity<Object>addMember(@RequestBody TeamMemberDto teamMemberDto){
    	log.info("Team member created");
    	log.error("Can not create the team member", teamMemberDto);
        return ResponseEntity.ok().body(memberService.saveMember(teamMemberDto));
    }
    @PutMapping("/editMember")
    public ResponseEntity<Object>editMember(@RequestBody TeamMemberDto teamMemberDto){
    	log.info("Team member updated");
    	log.error("Unable to update the team member", teamMemberDto);
        return ResponseEntity.ok().body(memberService.editMembers(teamMemberDto));
    }

    @GetMapping("/getProjectMembers/{project_id}")
    public ResponseEntity<Object>getAllProjectMembers(@PathVariable("project_id")int project_id){
    	log.info("Team members displayed");
    	log.error("Unable to display the team members", memberService);
        return ResponseEntity.ok().body(memberService.getTeamMembers(project_id));
    }
    @DeleteMapping("/deleteMembers/{id}")
    public ResponseEntity<Object>deleteProjectMembers(@PathVariable("id")int id){
        memberService.deleteMember(id);
    	log.info("Team member displayed");
    	log.error("Unable to display the team member with id", memberService);
        return ResponseEntity.ok().body("Member removed from project");
    }


}
