package com.code.springdemo.service;

import java.util.Random;

public class HappyFortuneService implements FortuneService {

    private String[] fortunes = { "Today is your lucky day!", "Stay safe and sound!", "Have a great day!" };

    private Random randomNum;

    public HappyFortuneService() {
        randomNum = new Random();
    }
    
    @Override
    public String getFortune() {
        int randomIndex = randomNum.nextInt(this.fortunes.length);
        return fortunes[Math.max(randomIndex, 0)];
    }
}
