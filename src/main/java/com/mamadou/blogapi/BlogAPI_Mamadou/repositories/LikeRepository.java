package com.mamadou.blogapi.BlogAPI_Mamadou.repositories;

import com.mamadou.blogapi.BlogAPI_Mamadou.models.Like;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.Post;
import com.mamadou.blogapi.BlogAPI_Mamadou.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LikeRepository extends JpaRepository<Like,Integer> {

    List<Like> findByPost(Post post);
    boolean existsByUserAndPost(User user, Post post);

}
