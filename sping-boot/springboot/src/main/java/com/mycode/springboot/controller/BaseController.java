package com.mycode.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @RequestMapping("/")
    public String retriveBasePage() {
        return "Hello at spring boot world. Your coach will be " + coachName + " and team name will be " + teamName + ".";
    }
}
