package com.mycode.springboot.entity;

// import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
// @Lazy
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practiced with Bowling aroung 30mintues";
    }

    @PostConstruct
    public void initBean() {
        System.out.println("Inside: Cricket coach bean at init");
    }

    @PreDestroy
    public void destoryBean() {
        System.out.println("Inside: Cricket coach bean at destory");
    }
}
