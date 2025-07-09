package com.mamadou.blogapi.BlogAPI_Mamadou.controllers;


import com.mamadou.blogapi.BlogAPI_Mamadou.models.Like;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.Post;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.User;
import com.mamadou.blogapi.BlogAPI_Mamadou.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/like")
public class LikeController {

    @Autowired
    LikeService service;

    @PostMapping
    public Like addLike(@RequestBody Like like){
        return service.addLike(like);
    }

    @GetMapping("/post")
    public List<Like> getLikesByPost(@RequestBody Post post){
        return service.getLikesByPost(post);
    }

    @DeleteMapping("/{id}")
    public Like unlike(@PathVariable int id){
        return service.unlike(id);
    }
}
