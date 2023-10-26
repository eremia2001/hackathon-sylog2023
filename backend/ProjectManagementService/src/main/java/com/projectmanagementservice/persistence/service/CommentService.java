package com.projectmanagementservice.persistence.service;


import com.projectmanagementservice.persistence.model.Comment;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.model.Task;
import com.projectmanagementservice.persistence.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    TaskService taskService;

    @Autowired
    ProjectService projectService;

    public List<Comment> findAllByTaskId(Long id){
        Task task = taskService.findById(id);
        return commentRepository.findAllByTask(task);
    }

    public List<Comment> findAllByProjectId(Long id){
        Project project = projectService.findById(id);
        return commentRepository.findAllByProject(project);
    }

    public Comment addCommentToTask(Long taskId, Comment comment){
        Task task = taskService.findById(taskId);
        comment.setTask(task);
        return commentRepository.save(comment);
    }

    public Comment addCommentToProject(Long projectId, Comment comment){
        Project project = projectService.findById(projectId);
        comment.setProject(project);
        return commentRepository.save(comment);
    }

    public void deleteById(Long commentId){
        commentRepository.deleteById(commentId);
    }
}
