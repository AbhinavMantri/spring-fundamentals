package com.mycode.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycode.springboot.entity.Coach;

@RestController
public class CoachController {
    private Coach coach;

    public CoachController(
      @Autowired 
      @Qualifier("cricketCoach") 
      Coach coach
    ) {
        this.coach = coach;
    }

    @RequestMapping("/workout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
