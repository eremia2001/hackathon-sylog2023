package com.projectmanagementservice.api.service;

import com.projectmanagementservice.api.model.ImageDto;
import com.projectmanagementservice.api.model.ProjectDto;
import com.projectmanagementservice.persistence.model.ImageEntity;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

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
        projectDto.setMemberIds(project.getMembers().stream().map(Member::getId).toList());
        List<ImageDto> imageDtoList = project.getImages().stream().map(this::imageToImageDto).toList();
        projectDto.setImages(imageDtoList);

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
