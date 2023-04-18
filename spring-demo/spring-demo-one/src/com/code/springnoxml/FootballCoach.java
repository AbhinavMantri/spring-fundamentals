package com.code.springnoxml;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

    @Override
    public String getDailyWorkout() {
       return "Practiced for 2hours";
    }
    
}
