package com.code.springdemo;

import com.code.springdemo.service.FortuneService;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    // define a constructor
    public BaseballCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Spending 30 mintues on batting practice";
    }

    @Override
    public String getDailyFortune() {
        // call the dependeny injection object method
        return this.fortuneService.getFortune();
    }
}
