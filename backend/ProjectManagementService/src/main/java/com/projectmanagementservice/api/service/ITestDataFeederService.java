package com.projectmanagementservice.api.service;

import com.projectmanagementservice.persistence.model.Member;
import com.projectmanagementservice.persistence.model.Organization;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ITestDataFeederService {
    public void createTestData();

    public List<Project> createDummyProjects();

    public List<Task> createDummyTasks();

    public List<Organization> createDummyOrganizations();

    public List<Member> createDummyMembers();
}
