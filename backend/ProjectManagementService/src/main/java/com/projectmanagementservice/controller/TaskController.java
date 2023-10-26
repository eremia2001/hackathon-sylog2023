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
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    List<Task> getTasks(){
        return taskRepository.findAll();
    }

    @GetMapping("/task/{id}")
    Task getTask(@PathVariable Long id){
        return taskRepository.getReferenceById(id);
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    String projectNotFoundHandler(EntityNotFoundException e){
        return e.getMessage();
    }
}
