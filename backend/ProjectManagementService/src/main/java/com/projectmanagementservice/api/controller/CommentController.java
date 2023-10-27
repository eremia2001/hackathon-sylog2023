package com.projectmanagementservice.api.controller;

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
    CrudCommentService crudCommentService;

    @GetMapping("/comments/tasks/{taskId}")
    List<Comment> getCommentsForTask(@PathVariable Long taskId){
        return crudCommentService.findAllByTaskId(taskId);
    }

    @GetMapping("/comments/projects/{projectId}")
    List<Comment> getCommentsForProject(@PathVariable Long projectId){
        return crudCommentService.findAllByProjectId(projectId);
    }

    @PostMapping("/comments/tasks/{taskId}")
    ResponseEntity<Comment> addCommentToTask(@PathVariable Long taskId, @RequestBody Comment comment){
        Comment c = crudCommentService.addCommentToTask(taskId, comment);
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @PostMapping("/comments/projects/{projectId}")
    ResponseEntity<Comment> addCommentToProject(@PathVariable Long projectId, @RequestBody Comment comment){
        Comment c = crudCommentService.addCommentToProject(projectId, comment);
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @DeleteMapping("/comments/delete/{commentId}")
    ResponseEntity<String> deleteComment(@PathVariable Long commentId){
        crudCommentService.deleteById(commentId);
        return ResponseEntity.status(HttpStatus.OK).body("Comment deleted");
    }
}
