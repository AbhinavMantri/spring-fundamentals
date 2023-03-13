package com.code.springnoxml;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringNoXmlApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportsConfig.class);

        Coach coach = context.getBean("footballCoach", FootballCoach.class);
        
        System.out.println(coach.getDailyWorkout());

        context.close();
    }
}
