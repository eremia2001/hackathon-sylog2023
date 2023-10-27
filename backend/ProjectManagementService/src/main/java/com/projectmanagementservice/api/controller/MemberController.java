package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.crud.CrudMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    CrudMemberService crudMemberService;

    @GetMapping("/members")
    List<Member> getMembers(){
        return crudMemberService.findAll();
    }

    @GetMapping("/members/{id}")
    Member getMember(@PathVariable Long id){
        return crudMemberService.findById(id);
    }

    @PostMapping("/members/create")
    ResponseEntity<Member> addMember(@RequestBody Member member){
        Member m = crudMemberService.addMember(member);
        return ResponseEntity.status(HttpStatus.OK).body(m);
    }

    @DeleteMapping("/members/delete/{memberId}")
    ResponseEntity<String> deleteMember(@PathVariable Long memberId){
        crudMemberService.deleteById(memberId);
        return ResponseEntity.status(HttpStatus.OK).body("Member deleted");
    }
}
