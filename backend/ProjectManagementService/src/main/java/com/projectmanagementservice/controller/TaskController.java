package com.projectmanagementservice.controller;

import com.projectmanagementservice.model.Task;
import com.projectmanagementservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository TaskRepository) {
        this.taskRepository = TaskRepository;
    }

    @GetMapping("/projects")
    List<Task> getTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("/projects/{id}")
    Task getTask(@PathVariable Long id){
        return taskRepository.getReferenceById(id);
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    String projectNotFoundHandler(EntityNotFoundException e){
        return e.getMessage();
    }
}
