package com.code.springdemo;

import com.code.springdemo.service.FortuneService;

public class CricketCoach implements Coach {

    private FortuneService fortuneService;

    private String emailAddress;

    private String team;

    private int size;

    public CricketCoach() {
        System.out.println("We are at Cricket Coach constructor method");
    }

    public void setEmailAddress(String emailAddress) {
        System.out.println("We are at setter of email address method");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("We are at setter of team method");
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 60 minutes";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("We are at setter of fortune method");
        this.fortuneService = fortuneService;
    }
}
