package com.mamadou.blogapi.BlogAPI_Mamadou.services;


import com.mamadou.blogapi.BlogAPI_Mamadou.models.Like;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.Post;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.User;
import com.mamadou.blogapi.BlogAPI_Mamadou.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    LikeRepository repo;

    public Like addLike(Like like){
        User user = like.getUser();
        Post post = like.getPost();
        if (repo.existsByUserAndPost(user, post)) {
            throw new IllegalStateException("User already liked this post");
        }

        return repo.save(like);
    }

    public List<Like>getLikesByPost(Post post){
        return repo.findByPost(post);
    }

    public Like unlike(int id){
        Like like=repo.findById(id).orElseThrow(()->new RuntimeException("Like Not Found"));
        repo.delete(like);
        return like;
    }

}
