package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.api.model.ProjectDto;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping("/projects")
    List<Project> getProjects(){
        return projectService.findAll();
    }

    @GetMapping("/projects/{project_id}")
    Project getProjectByID(@PathVariable Long project_id){
        return projectService.findById(project_id);
    }

    @GetMapping("/projects/members/{member_id}")
    Set<Project> getMyProjects(@PathVariable Long member_id){
        return projectService.findProjectsOfMember(member_id);
    }

    @PostMapping("/projects/create")
    ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto dto){
        Project pr = projectService.addProject(dto);
        return ResponseEntity.status(HttpStatus.OK).body(new ProjectDto());
    }

    @DeleteMapping("/projects/delete/{projectId}")
    ResponseEntity<String> deleteProject(@PathVariable Long projectId){
        projectService.deleteById(projectId);
        return ResponseEntity.status(HttpStatus.OK).body("Project deleted");
    }
}
