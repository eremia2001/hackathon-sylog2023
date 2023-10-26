package com.projectmanagementservice.controller;

import com.projectmanagementservice.model.Member;
import com.projectmanagementservice.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/members")
    List<Member> getMembers(){
        return memberRepository.findAll();
    }

    @GetMapping("/members/{id}")
    Member getMember(@PathVariable Long id){
        return memberRepository.getReferenceById(id);
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    String projectNotFoundHandler(EntityNotFoundException e){
        return e.getMessage();
    }
}
