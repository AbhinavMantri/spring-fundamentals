package com.mycode.springboot.service;

import com.mycode.springboot.entity.User;

public interface AuthService {
    public String login(String userName, String password);

    public boolean authenticate(String token);

    public String signUp(User user);
}
