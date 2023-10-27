package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.api.model.ProjectDto;
import com.projectmanagementservice.api.service.ProjectService;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.crud.CrudProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ProjectController {

    @Autowired
    CrudProjectService crudProjectService;

    @Autowired
    ProjectService projectService;


    @GetMapping("/api/projects")
    List<ProjectDto> getProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/api/projects/{projectId}")
    ProjectDto getProjectByID(@PathVariable Long projectId){
        return projectService.getProjectById(projectId);
    }

    @PostMapping("/api/projects/create")
    ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto dto){
        ProjectDto pDto = projectService.addProject(dto);
        return ResponseEntity.status(HttpStatus.OK).body(pDto);
    }

    @DeleteMapping("/api/projects/delete/{projectId}")
    ResponseEntity<String> deleteProject(@PathVariable Long projectId){
        crudProjectService.deleteById(projectId);
        return ResponseEntity.status(HttpStatus.OK).body("Project deleted");
    }
}
