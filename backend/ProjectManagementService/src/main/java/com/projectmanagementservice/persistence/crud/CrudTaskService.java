package com.projectmanagementservice.persistence.crud;

import com.projectmanagementservice.exception.BadContentException;
import com.projectmanagementservice.exception.NotFoundException;
import com.projectmanagementservice.persistence.model.*;
import com.projectmanagementservice.persistence.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CrudTaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CrudProjectService crudProjectService;

    @Autowired
    CrudMemberService crudMemberService;


    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task findById(Long taskId){
        return taskRepository.findById(taskId).
                orElseThrow(() -> new NotFoundException(String.format("Task with ID %s not found!", taskId)));
    }

    public Task assignMember(Long memberId, Long taskId){
        Task task = findById(taskId);
        Project project = task.getProject();
        Member member = crudMemberService.findById(memberId);

        if(!project.getMembers().contains(member)) {
            throw new NotFoundException(String.format("Member with ID %s is not part of the task's project you are trying to assign to!", memberId));
        }

        task.setAssignedMember(member);
        return taskRepository.save(task);
    }

    public Set<Project> findProjectsOfMember(Long memberId){
        Member member = crudMemberService.findById(memberId);
        Organization member_org =  member.getOrganization();
        return member_org.getProjects();
    }

    public Task updateState(Long taskId, String newStatus){
        TaskState state = switch(newStatus) {
            case "OPEN" -> TaskState.OPEN;
            case "DONE" -> TaskState.DONE;
            case "IN_PROGRESS" -> TaskState.IN_PROGRESS;
            default -> null;
        };
        if(state != null){
            Task task = taskRepository.findById(taskId).
                    orElseThrow(() -> new NotFoundException("Project with ID " + taskId + " not found!"));
            task.setState(state);
            return taskRepository.save(task);
        }
        else{
            throw new BadContentException("Invalid input");
        }
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteById(Long projectId){
        taskRepository.deleteById(projectId);
    }
}
