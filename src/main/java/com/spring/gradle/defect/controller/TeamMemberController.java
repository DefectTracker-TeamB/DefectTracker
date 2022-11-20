package com.spring.gradle.defect.controller;

import com.spring.gradle.defect.dto.TeamMemberDto;
import com.spring.gradle.defect.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class TeamMemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/addMember")
    public ResponseEntity<Object> addMember(@RequestBody TeamMemberDto teamMemberDto) {
        return ResponseEntity.ok().body(memberService.saveMember(teamMemberDto));
    }

    @PutMapping("/editMember")
    public ResponseEntity<Object> editMember(@RequestBody TeamMemberDto teamMemberDto) {
        return ResponseEntity.ok().body(memberService.editMembers(teamMemberDto));
    }

    @GetMapping("/getProjectMembers/{project_id}")
    public ResponseEntity<Object> getAllProjectMembers(@PathVariable("project_id") int project_id) {
        return ResponseEntity.ok().body(memberService.getTeamMembers(project_id));
    }

    @DeleteMapping("/deleteMembers/{id}")
    public ResponseEntity<Object> deleteProjectMembers(@PathVariable("id") int id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().body("Member removed from project");
    }


}
