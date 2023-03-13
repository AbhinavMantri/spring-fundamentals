package com.code.springdemo;

import org.springframework.beans.factory.DisposableBean;

import com.code.springdemo.service.FortuneService;

public class TrackCoach implements Coach, DisposableBean {

    private FortuneService fortuneService;
    
    public TrackCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    public void initTrackCoachBean() {
        System.out.println("Initated the trackCoach bean");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destoryed the trackCoach bean");
    }
}
