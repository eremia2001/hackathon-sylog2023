package com.projectmanagementservice.persistence.crud;


import com.projectmanagementservice.persistence.model.Comment;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.model.Task;
import com.projectmanagementservice.persistence.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudCommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CrudTaskService crudTaskService;

    @Autowired
    CrudProjectService crudProjectService;

    public List<Comment> findAllByTaskId(Long id){
        Task task = crudTaskService.findById(id);
        return commentRepository.findAllByTask(task);
    }

    public List<Comment> findAllByProjectId(Long id){
        Project project = crudProjectService.findById(id);
        return commentRepository.findAllByProject(project);
    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public void deleteById(Long commentId){
        commentRepository.deleteById(commentId);
    }
}
