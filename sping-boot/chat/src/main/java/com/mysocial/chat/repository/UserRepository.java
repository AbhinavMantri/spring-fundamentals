package com.mysocial.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysocial.chat.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
