package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    List<Member> getMembers(){
        return memberService.findAll();
    }

    @GetMapping("/members/{id}")
    Member getMember(@PathVariable Long id){
        return memberService.findById(id);
    }

    @PostMapping("/members/create")
    ResponseEntity<Member> addMember(@RequestBody Member member){
        Member m = memberService.addMember(member);
        return ResponseEntity.status(HttpStatus.OK).body(m);
    }

    @DeleteMapping("/members/delete/{memberId}")
    ResponseEntity<String> deleteMember(@PathVariable Long memberId){
        memberService.deleteById(memberId);
        return ResponseEntity.status(HttpStatus.OK).body("Member deleted");
    }
}
