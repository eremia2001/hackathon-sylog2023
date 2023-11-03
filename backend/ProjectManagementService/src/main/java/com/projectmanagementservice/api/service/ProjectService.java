package com.projectmanagementservice.api.service;

import com.projectmanagementservice.api.model.ProjectDto;
import com.projectmanagementservice.exception.NotFoundException;
import com.projectmanagementservice.persistence.crud.CrudImageService;
import com.projectmanagementservice.persistence.crud.CrudOrganizationService;
import com.projectmanagementservice.persistence.crud.CrudProjectService;
import com.projectmanagementservice.persistence.model.ImageEntity;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Service
public class ProjectService {

    @Autowired
    CrudProjectService crudProjectService;

    @Autowired
    CrudOrganizationService crudOrganizationService;

    @Autowired
    CrudImageService crudImageService;

    @Autowired
    MappingService mappingService;

    public ProjectDto addProject(ProjectDto dto){
        Project project = Project.builder()
                .id(dto.getId())
                .name(dto.getName())
                .organization(crudOrganizationService.findById(dto.getOrganizationId()))
                .description(dto.getDescription())
                .startDate(Date.valueOf(dto.getStartDate()))
                .endDate(Date.valueOf(dto.getEndDate()))
                .budget(dto.getBudget())
                .build();

        addImagesToProject(dto, project);

        return mappingService.projectToProjectDto(crudProjectService.save(project));
    }

    private void addImagesToProject(ProjectDto dto, Project project) {
        if (dto.getImages() != null && !dto.getImages().isEmpty()) {
            dto.getImages().forEach(img -> {
                ImageEntity imgEntity = new ImageEntity();
                imgEntity.setName(img.getName());
                imgEntity.setImageBytes(img.getBytes());
                imgEntity.setProject(project);
                crudImageService.save(imgEntity);
            });
        }
    }

    public List<ProjectDto> getAllProjects() {
        return crudProjectService.findAll().stream().map(mappingService::projectToProjectDto).toList();
    }

    public ProjectDto getProjectById(final Long id) {
        return mappingService.projectToProjectDto(crudProjectService.findById(id));
    }
}
