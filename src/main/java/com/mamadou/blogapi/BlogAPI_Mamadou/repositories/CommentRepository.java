package com.mamadou.blogapi.BlogAPI_Mamadou.repositories;

import com.mamadou.blogapi.BlogAPI_Mamadou.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
