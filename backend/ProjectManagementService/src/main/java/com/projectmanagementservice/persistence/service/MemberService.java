package com.projectmanagementservice.persistence.service;

import com.projectmanagementservice.exception.NotFoundException;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(Long member_id){
        return memberRepository.findById(member_id).
                orElseThrow(() -> new NotFoundException("Member with ID " + member_id + " not found!"));
    }

    public Member addMember(Member member){
        return memberRepository.save(member);
    }

    public void deleteById(Long memberId){
        memberRepository.deleteById(memberId);
    }
}
