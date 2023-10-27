package com.projectmanagementservice.persistence.repository;

import com.projectmanagementservice.persistence.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    Set<Task> findAllByProjectId(Long projectId);
}
