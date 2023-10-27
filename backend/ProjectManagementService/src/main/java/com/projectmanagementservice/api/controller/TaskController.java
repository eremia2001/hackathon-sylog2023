package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.persistence.model.Task;
import com.projectmanagementservice.persistence.crud.CrudTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    CrudTaskService crudTaskService;

    @GetMapping("/tasks")
    List<Task> getTasks(){
        return crudTaskService.findAll();
    }

    @GetMapping("/tasks/{taskId}")
    Task getTaskById(@PathVariable Long taskId){
        return crudTaskService.findById(taskId);
    }

    @PutMapping("/tasks/{task_id}/members/{memberId}")
    ResponseEntity<Task> assignMemberToTask(@PathVariable Long memberId, @PathVariable Long task_id){
        Task t = crudTaskService.assignMember(memberId, task_id);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PutMapping("/tasks/{taskId}/state/{newState}")
    ResponseEntity<Task> updateTaskState(@PathVariable Long taskId, @PathVariable String newState){
        Task t = crudTaskService.updateState(taskId, newState);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PostMapping("/tasks/create")
    ResponseEntity<Task> addTask(@RequestBody Task task){
        Task t = crudTaskService.addTask(task);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @DeleteMapping("/tasks/delete/{taskId}")
    ResponseEntity<String> deleteTask(@PathVariable Long taskId){
        crudTaskService.deleteById(taskId);
        return ResponseEntity.status(HttpStatus.OK).body("Task deleted");
    }
}
