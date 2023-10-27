package com.projectmanagementservice.persistence.crud;

import com.projectmanagementservice.api.model.ProjectDto;
import com.projectmanagementservice.exception.NotFoundException;
import com.projectmanagementservice.persistence.model.ImageEntity;
import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Organization;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class CrudProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    CrudMemberService crudMemberService;

    @Autowired
    CrudOrganizationService crudOrganizationService;

    @Autowired
    CrudImageService crudImageService;

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long project_id) {
        return projectRepository.findById(project_id).
                orElseThrow(() -> new NotFoundException("Project with ID " + project_id + " not found!"));
    }

    public Set<Project> findProjectsOfMember(Long member_id) {
        Member member = crudMemberService.findById(member_id);
        Organization memberOrg = member.getOrganization();
        return memberOrg.getProjects();
    }

    public Project addProject(ProjectDto dto) {
        Project project = new Project();
        project.setName(dto.getName());

        Organization organization = crudOrganizationService.findById(dto.getOrganizationId());
        project.setOrganization(organization);

        project.setDescription(dto.getDescription());

        project.setStartDate(Date.valueOf(dto.getStartDate()));
        project.setEndDate(Date.valueOf(dto.getEndDate()));

        Set<Member> projectMembers = new HashSet<>();
        if (dto.getMemberIds() != null) {
            dto.getMemberIds().forEach(mId -> {

                Member m = crudMemberService.findById(mId);
                if (!project.getMembers().contains(m)) {
                    throw new NotFoundException(String.format("Member with ID %s you are trying to assign to project, is not part of the project's organization!", mId));
                }
                projectMembers.add(m);

            });
        }
        project.setMembers(projectMembers);


        if (dto.getImages() != null) {
            dto.getImages().forEach(img -> {
                ImageEntity imgEntity = new ImageEntity();
                imgEntity.setName(img.getName());
                imgEntity.setImageBytes(img.getBytes());
                imgEntity.setProject(project);
                crudImageService.save(imgEntity);
            });
        }

        return projectRepository.save(project);
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public void deleteById(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
