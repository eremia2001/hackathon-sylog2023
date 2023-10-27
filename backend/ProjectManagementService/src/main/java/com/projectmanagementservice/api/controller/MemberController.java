package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.api.service.TaskService;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.crud.CrudMemberService;
import com.projectmanagementservice.persistence.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class MemberController {
    @Autowired
    CrudMemberService crudMemberService;

    @Autowired
    TaskService taskService;

    @GetMapping("/api/members")
    List<Member> getMembers(){
        return crudMemberService.findAll();
    }

    @GetMapping("/api/members/{id}")
    Member getMember(@PathVariable Long id){
        return crudMemberService.findById(id);
    }

    @GetMapping("/api/members/{memberId}/organizations/projects")
    Set<Project> getProjectsOfMemberOrg(@PathVariable Long memberId){
        return crudMemberService.findProjectsOfMemberOrg(memberId);
    }

    @GetMapping("/api/members/{memberId}/organizations/projects/active")
    Set<Project> getActiveProjects(@PathVariable Long memberId){
        return crudMemberService.findActiveProjects(memberId);
    }

    @PostMapping("/api/members/create")
    ResponseEntity<Member> addMember(@RequestBody Member member){
        Member m = crudMemberService.save(member);
        return ResponseEntity.status(HttpStatus.OK).body(m);
    }

    @DeleteMapping("/api/members/delete/{memberId}")
    ResponseEntity<String> deleteMember(@PathVariable Long memberId){
        taskService.unassignMemberFromAllTasks(memberId);
        crudMemberService.deleteById(memberId);
        return ResponseEntity.status(HttpStatus.OK).body("Member deleted");
    }
}
