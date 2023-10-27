package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.api.service.TaskService;
import com.projectmanagementservice.persistence.model.Task;
import com.projectmanagementservice.persistence.crud.CrudTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class TaskController {
    @Autowired
    CrudTaskService crudTaskService;

    @Autowired
    TaskService taskService;

    @GetMapping("/api/tasks")
    List<Task> getTasks(){
        return crudTaskService.findAll();
    }

    @GetMapping("/api/tasks/{taskId}")
    Task getTaskById(@PathVariable Long taskId){
        return crudTaskService.findById(taskId);
    }

    @GetMapping("/api/tasks/members/{memberId}")
    Set<Task> getTasksOfMember(@PathVariable Long memberId){
        return crudTaskService.findTasksOfMember(memberId);
    }

    @GetMapping("/apitasks/projects/{projectId}")
    Set<Task> getTasksByProjectId(@PathVariable Long projectId){
        return crudTaskService.getTasksByProjectId(projectId);
    }

    @PutMapping("/api/tasks/{task_id}/members/{memberId}/assign")
    ResponseEntity<Task> assignMemberToTask(@PathVariable Long memberId, @PathVariable Long task_id){
        Task t = taskService.assignMember(memberId, task_id);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PutMapping("/api/tasks/{task_id}/members/{memberId}/unassign")
    ResponseEntity<Task> unAssignMemberFromTask(@PathVariable Long memberId, @PathVariable Long task_id){
        Task t = taskService.unAssignMember(memberId, task_id);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PutMapping("/api/tasks/{taskId}/state/{newState}")
    ResponseEntity<Task> updateTaskState(@PathVariable Long taskId, @PathVariable String newState){
        Task t = taskService.updateState(taskId, newState);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PostMapping("/api/tasks/create")
    ResponseEntity<Task> addTask(@RequestBody Task task){
        Task t = crudTaskService.save(task);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @DeleteMapping("/api/tasks/delete/{taskId}")
    ResponseEntity<String> deleteTask(@PathVariable Long taskId){
        crudTaskService.deleteById(taskId);
        return ResponseEntity.status(HttpStatus.OK).body("Task deleted");
    }
}
