package com.mamadou.blogapi.BlogAPI_Mamadou.controllers;


import com.mamadou.blogapi.BlogAPI_Mamadou.models.Post;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.User;
import com.mamadou.blogapi.BlogAPI_Mamadou.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService service;


    @PostMapping
    public Post createPost( @RequestBody Post post){
        return service.addPost(post);
    }

    @GetMapping
    public List<Post>getPosts(){
        return service.getPosts();
    }

    @GetMapping("/user")
    public List<Post>getPostByUser(@RequestBody User user){
        return service.findPostByUser(user);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable int id) {
        boolean deleted = service.deletePost(id);
        if (deleted) {
            return ResponseEntity.ok("Post deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Post not found.");
        }
    }

}
