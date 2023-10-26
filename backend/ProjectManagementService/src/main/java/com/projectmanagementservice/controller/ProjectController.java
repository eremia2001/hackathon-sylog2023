package com.projectmanagementservice.controller;

import com.projectmanagementservice.model.Project;
import com.projectmanagementservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/projects")
    List<Project> getProjects(){
        return projectRepository.findAll();
    }

    @GetMapping("/projects/{id}")
    Project getProject(@PathVariable Long id){
        return projectRepository.getReferenceById(id);
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    String projectNotFoundHandler(EntityNotFoundException e){
        return e.getMessage();
    }
}
