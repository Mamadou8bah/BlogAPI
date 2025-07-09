package com.mamadou.blogapi.BlogAPI_Mamadou.services;

import com.mamadou.blogapi.BlogAPI_Mamadou.models.Comment;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.User;
import com.mamadou.blogapi.BlogAPI_Mamadou.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository repo;
    public Comment addComment(Comment comment){
        return repo.save(comment);
    }
    public List<Comment>getComments(){
        return repo.findAll();
    }
    public List<Comment>getCommentsByUser(User user){
        return repo.findByUser(user);
    }

    public Comment getCommentById(int id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("No Comment with that ID"));
    }

    public Comment deleteComment(int id){
        Comment comment=repo.findById(id).orElseThrow(()->new RuntimeException("No Comment with that ID"));
        repo.delete(comment);
        return comment;
    }
}
