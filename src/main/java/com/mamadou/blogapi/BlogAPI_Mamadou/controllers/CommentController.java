package com.mamadou.blogapi.BlogAPI_Mamadou.controllers;


import com.mamadou.blogapi.BlogAPI_Mamadou.models.Comment;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.User;
import com.mamadou.blogapi.BlogAPI_Mamadou.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService service;

    @PostMapping
    public Comment addComment(@RequestBody Comment comment){
        return service.addComment(comment);
    }

    @GetMapping
    public List<Comment> getComments(){
        return service.getComments();
    }

    @GetMapping("/user")
    public List<Comment>getCommentsByUser(@RequestBody User user){
        return service.getCommentsByUser(user);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable int id){
        return service.getCommentById(id);
    }

    @DeleteMapping("/{id}")
    public Comment deleteComment(@PathVariable int id){
      return service.deleteComment(id);
    }
}
