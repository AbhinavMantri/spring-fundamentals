package com.code.springannotations.service;

import java.util.Random;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// bean scope
@Scope("singleton")
public class RandomFortuneService implements FortuneService {
    private String[] fortunes = { "Today is your lucky day!", "Stay safe and sound!", "Have a great day!" };

    private Random randomNum;

    public RandomFortuneService() {
        randomNum = new Random();
    }

    @Override
    public String getFortune() {
       int randomIndex = this.randomNum.nextInt(this.fortunes.length); 
       return fortunes[Math.max(randomIndex, 0)];
    }
    
}
