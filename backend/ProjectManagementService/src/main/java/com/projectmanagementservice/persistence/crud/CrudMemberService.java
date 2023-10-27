package com.projectmanagementservice.persistence.crud;

import com.projectmanagementservice.exception.NotFoundException;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Organization;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.model.Task;
import com.projectmanagementservice.persistence.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CrudMemberService {
    @Autowired
    MemberRepository memberRepository;

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findById(Long member_id){
        return memberRepository.findById(member_id).
                orElseThrow(() -> new NotFoundException("Member with ID " + member_id + " not found!"));
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }

    public void deleteById(Long memberId){
        memberRepository.deleteById(memberId);
    }

    public Set<Project> findProjectsOfMemberOrg(Long member_id) {
        Member member = findById(member_id);
        Organization memberOrg = member.getOrganization();
        return memberOrg.getProjects();
    }

    public Set<Project> findActiveProjects(Long memberId){
        Member member = findById(memberId);
        Set<Task> tasks = member.getAssignedTasks();
        Set<Project> activeProjects = new HashSet<>();
        for(Task task:tasks){
            activeProjects.add(task.getProject());
        }
        return activeProjects;
    }
}
