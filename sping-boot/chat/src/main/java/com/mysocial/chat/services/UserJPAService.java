package com.mysocial.chat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysocial.chat.entity.Post;
import com.mysocial.chat.entity.User;
import com.mysocial.chat.expections.UserNotFoundExpection;
import com.mysocial.chat.repository.UserRepository;

@Service
public class UserJPAService {

    @Autowired
    private UserRepository repository;

    public UserJPAService() {}

    // public UserJPAService(@Autowired UserRepository repository) {
    //     this.repository = repository;
    // }

    public List<User> getUsers() {
        return this.repository.findAll();
    }

    public Optional<User> getUser(int id) {
        return this.repository.findById(id);
    }

    public void addUser(User user) {
        this.repository.save(user);
    }

    public void deleteUser(int id) {
        this.repository.deleteById(id);
    }

    public List<Post> getUserPosts(int userId) {
        Optional<User> user = this.getUser(userId);

        if(user.isEmpty()) {
            throw new UserNotFoundExpection("User is not found");
        }

        return user.get().getPosts();
    }
}
