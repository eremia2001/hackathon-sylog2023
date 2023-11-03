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
    public Set<Task> findTasksOfMember(Long memberId){
        Member member = crudMemberService.findById(memberId);
        return member.getAssignedTasks();
    }

    public Set<Task> getTasksByProjectId(Long projectId){
        return taskRepository.findAllByProjectId(projectId);
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

    public void deleteById(Long projectId){
        taskRepository.deleteById(projectId);
    }
}
