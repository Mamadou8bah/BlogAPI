package com.mamadou.blogapi.BlogAPI_Mamadou.repositories;

import com.mamadou.blogapi.BlogAPI_Mamadou.models.Comment;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findByUser(User user);
}
