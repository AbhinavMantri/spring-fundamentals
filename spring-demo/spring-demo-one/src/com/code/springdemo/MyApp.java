package com.code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyApp {
    public static void main(String[] args) {

        // load spring configuration file
        ClassPathXmlApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");


        System.out.println("Start running the main program");

        // retrieve the bean
        Coach theCoach = context.getBean("myCoach",Coach.class);
        Coach trackCoach = context.getBean("tCoach", Coach.class);
        CricketCoach cricketCoach = context.getBean("cCoach", CricketCoach.class);

        // call the object method
        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        System.out.println(trackCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyFortune());

        System.out.println(cricketCoach.getDailyWorkout());
        System.out.println(cricketCoach.getDailyFortune());
        System.out.println(cricketCoach.getEmailAddress());
        System.out.println(cricketCoach.getTeam());
        System.out.println(cricketCoach.getSize());

        // close the context
        context.close();
    }
}
