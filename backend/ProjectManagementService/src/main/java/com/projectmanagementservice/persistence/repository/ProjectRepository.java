package com.projectmanagementservice.persistence.repository;

import com.projectmanagementservice.persistence.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
