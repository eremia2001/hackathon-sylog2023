package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.api.service.CommentService;
import com.projectmanagementservice.persistence.model.Comment;
import com.projectmanagementservice.persistence.crud.CrudCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    CrudCommentService crudCommentService;

    @GetMapping("/api/comments/tasks/{taskId}")
    List<Comment> getCommentsForTask(@PathVariable Long taskId){
        return crudCommentService.findAllByTaskId(taskId);
    }

    @GetMapping("/api/comments/projects/{projectId}")
    List<Comment> getCommentsForProject(@PathVariable Long projectId){
        return crudCommentService.findAllByProjectId(projectId);
    }

    @PostMapping("/api/comments/tasks/{taskId}")
    ResponseEntity<Comment> addCommentToTask(@PathVariable Long taskId, @RequestBody Comment comment){
        Comment c = commentService.addCommentToTask(taskId, comment);
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @PostMapping("/api/comments/projects/{projectId}")
    ResponseEntity<Comment> addCommentToProject(@PathVariable Long projectId, @RequestBody Comment comment){
        Comment c = commentService.addCommentToProject(projectId, comment);
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @DeleteMapping("/api/comments/delete/{commentId}")
    ResponseEntity<String> deleteComment(@PathVariable Long commentId){
        crudCommentService.deleteById(commentId);
        return ResponseEntity.status(HttpStatus.OK).body("Comment deleted");
    }
}
