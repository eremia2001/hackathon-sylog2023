package com.projectmanagementservice.api.service;

import com.projectmanagementservice.api.model.ProjectDto;
import com.projectmanagementservice.persistence.crud.CrudProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    CrudProjectService crudProjectService;
    @Autowired
    MappingService mappingService;

    public ProjectDto addProject(ProjectDto pDto){
        return mappingService.projectToProjectDto(crudProjectService.addProject(pDto));
    }

    public List<ProjectDto> getAllProjects() {
        return crudProjectService.findAll().stream().map(mappingService::projectToProjectDto).toList();
    }

    public ProjectDto getProjectById(final Long id) {
        return mappingService.projectToProjectDto(crudProjectService.findById(id));
    }
}
