package com.mysocial.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysocial.chat.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
    
}
