package com.projectmanagementservice.api.service;

import com.projectmanagementservice.persistence.crud.CrudCommentService;
import com.projectmanagementservice.persistence.crud.CrudProjectService;
import com.projectmanagementservice.persistence.crud.CrudTaskService;
import com.projectmanagementservice.persistence.model.Comment;
import com.projectmanagementservice.persistence.model.Project;
import com.projectmanagementservice.persistence.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    CrudCommentService crudCommentService;

    @Autowired
    CrudProjectService crudProjectService;

    @Autowired
    CrudTaskService crudTaskService;

    public Comment addCommentToProject(Long projectId, Comment comment){
        Project project = crudProjectService.findById(projectId);
        comment.setProject(project);
        return crudCommentService.save(comment);
    }

    public Comment addCommentToTask(Long taskId, Comment comment){
        Task task = crudTaskService.findById(taskId);
        comment.setTask(task);
        return crudCommentService.save(comment);
    }

}
