package com.code.springannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAnnotationApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation-applicationContext.xml");

        Coach coach = context.getBean("tennisCoach", Coach.class);


        System.out.println(coach.getDailyWorkout());

        System.out.println(coach.getDailyFortune());

        context.close();
    }
}
