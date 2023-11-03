package com.projectmanagementservice.api.service;

import com.projectmanagementservice.api.model.ImageDto;
import com.projectmanagementservice.api.model.ProjectDto;
import com.projectmanagementservice.persistence.model.ImageEntity;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MappingService {

    public ProjectDto projectToProjectDto(final Project project) {
        if (project == null) {
            return null;
        }

        final ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setDescription(project.getDescription());
        projectDto.setStartDate(project.getStartDate().toString());
        projectDto.setEndDate(project.getEndDate().toString());
        projectDto.setBudget(project.getBudget());
        projectDto.setStatus(project.getStatus().toString());
//
//        Set<Member> members;
//        if(project.getMembers() != null && !project.getMembers().isEmpty()){
//            members = project.getMembers();
//        } else {
//            members = Set.of();
//        }
//        projectDto.setMembers(members.stream().toList());

        Set<Task> tasks;
        if(project.getTasks() != null && !project.getTasks().isEmpty()){
            tasks = project.getTasks();
        } else {
            tasks = Set.of();
        }
        projectDto.setTasks(tasks.stream().toList());

        List<ImageDto> imageDtoList;
        if(!project.getImages().isEmpty()){
            imageDtoList = project.getImages().stream().map(this::imageToImageDto).toList();
        }
        else{
            imageDtoList = List.of();
        }
        projectDto.setImages(imageDtoList);
        projectDto.setOrganizationId(project.getOrganization().getId());

        return projectDto;
    }

    public ImageDto imageToImageDto(final ImageEntity image) {
        if (image == null) {
            return null;
        }

        final ImageDto imageDto = new ImageDto();
        imageDto.setId(image.getId());
        imageDto.setName(image.getName());
        imageDto.setBytes(image.getImageBytes());
        imageDto.setProjectId(image.getProject().getId());

        return imageDto;
    }

}
