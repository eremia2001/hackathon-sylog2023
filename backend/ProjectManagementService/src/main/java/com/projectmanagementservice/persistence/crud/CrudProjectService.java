package com.projectmanagementservice.persistence.crud;

import com.projectmanagementservice.exception.NotFoundException;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Organization;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.model.Task;
import com.projectmanagementservice.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CrudProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    CrudOrganizationService crudOrganizationService;

    @Autowired
    CrudImageService crudImageService;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long projectId) {
        return projectRepository.findById(projectId).
                orElseThrow(() -> new NotFoundException(String.format("Project with ID %s not found!", projectId)));
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public void deleteById(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
