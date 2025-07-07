package com.mamadou.blogapi.BlogAPI_Mamadou.repositories;

import com.mamadou.blogapi.BlogAPI_Mamadou.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
