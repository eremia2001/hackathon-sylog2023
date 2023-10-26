package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.persistence.model.Task;
import com.projectmanagementservice.persistence.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("/tasks")
    List<Task> getTasks(){
        return taskService.findAll();
    }

    @GetMapping("/tasks/{taskId}")
    Task getTaskById(@PathVariable Long taskId){
        return taskService.findById(taskId);
    }

    @PutMapping("/tasks/{task_id}/members/{memberId}")
    ResponseEntity<Task> assignMemberToTask(@PathVariable Long memberId, @PathVariable Long task_id){
        Task t = taskService.assignMember(memberId, task_id);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PutMapping("/tasks/{taskId}/state/{newState}")
    ResponseEntity<Task> updateTaskState(@PathVariable Long taskId, @PathVariable String newState){
        Task t = taskService.updateState(taskId, newState);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @PostMapping("/tasks/create")
    ResponseEntity<Task> addTask(@RequestBody Task task){
        Task t = taskService.addTask(task);
        return ResponseEntity.status(HttpStatus.OK).body(t);
    }

    @DeleteMapping("/tasks/delete/{taskId}")
    ResponseEntity<String> deleteTask(@PathVariable Long taskId){
        taskService.deleteById(taskId);
        return ResponseEntity.status(HttpStatus.OK).body("Task deleted");
    }
}
