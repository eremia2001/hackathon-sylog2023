package com.projectmanagementservice.api.service;

import com.projectmanagementservice.exception.BadContentException;
import com.projectmanagementservice.exception.NotFoundException;
import com.projectmanagementservice.persistence.crud.CrudMemberService;
import com.projectmanagementservice.persistence.crud.CrudTaskService;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Task;
import com.projectmanagementservice.persistence.model.TaskState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    CrudTaskService crudTaskService;

    @Autowired
    CrudMemberService crudMemberService;


    public Task assignMember(Long memberId, Long taskId){
        Task task = crudTaskService.findById(taskId);
        Member member = crudMemberService.findById(memberId);

        task.setAssignedMember(member);
        return crudTaskService.save(task);
    }

    public Task unAssignMember(Long memberId, Long taskId){
        Task task = crudTaskService.findById(taskId);
        Member member = crudMemberService.findById(memberId);

        if(!task.getAssignedMember().equals(member)) {
            throw new NotFoundException(String.format("Member with ID %s is is not assigned to the given task with ID %s", memberId, taskId));
        }

        task.setAssignedMember(null);
        return crudTaskService.save(task);
    }

    public void unassignMemberFromAllTasks(Long memberId){
        Member member = crudMemberService.findById(memberId);
        for(Task task:member.getAssignedTasks()){
            unAssignMember(member.getId(),task.getId());
        }
    }

    public Task updateState(Long taskId, String newStatus){
        TaskState state = switch(newStatus) {
            case "OPEN" -> TaskState.OPEN;
            case "DONE" -> TaskState.DONE;
            case "IN_PROGRESS" -> TaskState.IN_PROGRESS;
            default -> null;
        };
        if (state != null) {
            Task task = crudTaskService.findById(taskId);
            task.setState(state);
            return crudTaskService.save(task);
        } else {
            throw new BadContentException("Invalid input");
        }
    }
}
