package com.mamadou.blogapi.BlogAPI_Mamadou.services;


import com.mamadou.blogapi.BlogAPI_Mamadou.models.Post;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.User;
import com.mamadou.blogapi.BlogAPI_Mamadou.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {


    @Autowired
    PostRepository repo;

    public Post addPost(Post post){
        return repo.save(post);
    }

    public List<Post>getPosts(){
        return repo.findAll();
    }
    public List<Post>findPostByUser(User user){
        return repo.findByUser(user);
    }

    public Post findById(int id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("Could not find post"));
    }

    public boolean deletePost(int id) {
        Optional<Post> post = repo.findById(id);
        if (post.isPresent()) {
            repo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
