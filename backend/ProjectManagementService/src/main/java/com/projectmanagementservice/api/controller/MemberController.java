package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
