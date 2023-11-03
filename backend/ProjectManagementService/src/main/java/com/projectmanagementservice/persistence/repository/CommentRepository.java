package com.projectmanagementservice.persistence.repository;

import com.projectmanagementservice.persistence.model.Comment;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByTask(Task task);

    List<Comment> findAllByProject(Project project);
}
