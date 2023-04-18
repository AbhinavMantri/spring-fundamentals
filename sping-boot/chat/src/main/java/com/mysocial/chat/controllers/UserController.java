package com.mysocial.chat.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import com.mysocial.chat.entity.Post;
import com.mysocial.chat.entity.User;
import com.mysocial.chat.expections.UserNotFoundExpection;
import com.mysocial.chat.services.UserJPAService;
// import com.mysocial.chat.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    // private UserService userService;

    private UserJPAService userJPAService;

    public UserController(
        // @Autowired UserService userService, 
        @Autowired UserJPAService userJPAService) {
        // this.userService = userService;
        this.userJPAService = userJPAService;
    }

    @GetMapping(path = "/")
    public List<User> retrievUsers() {
        return this.userJPAService.getUsers();
    }

    @GetMapping(path = "/{id}")
    public EntityModel<User> retrievUser(@PathVariable int id) {
        // User user = this.userService.retrieveUser(id);

        Optional<User> user = this.userJPAService.getUser(id);

        if (user.isEmpty()) {
            throw new UserNotFoundExpection("User is not found");
        }

        EntityModel userEntity = EntityModel.of(user.get());

        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrievUsers());

        userEntity.add(linkBuilder.withRel("all-users"));

        return userEntity;
    }

    @PostMapping(path = "/")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        this.userJPAService.addUser(user);

        URI url = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(user.getId())
            .toUri();

        return ResponseEntity.created(url).body(user);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userJPAService.deleteUser(id);
    }

    @GetMapping(path = "/{id}/posts")
    public List<Post> retrievUserPosts(@PathVariable int id) {
        // User user = this.userService.retrieveUser(id);

        // Optional<User> user = this.userJPAService.getUser(id);

        // if (user.isEmpty()) {
        //     throw new UserNotFoundExpection("User is not found");
        // }

        List<Post> posts = this.userJPAService.getUserPosts(id);

        // EntityModel userEntity = EntityModel.of(user.get());

        // WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrievUsers());

        // WebMvcLinkBuilder linkBuilder1 = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrievUser(id));

        // userEntity.add(linkBuilder.withRel("all-users"));

        // userEntity.add(linkBuilder1.withRel("get-user"));

        return posts;
    }
}
