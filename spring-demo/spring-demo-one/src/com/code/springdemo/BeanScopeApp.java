package com.code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {
    public static void main(String[] args) {

        // load the context file
        ClassPathXmlApplicationContext context = 
          new ClassPathXmlApplicationContext("bean-scope-applicationContext.xml");

        
        Coach coach = context.getBean("tCoach", Coach.class);

        // Coach alphaCoach = context.getBean("tCoach", Coach.class);

        // boolean result = coach == alphaCoach;

        // System.out.println("Compare the objects\n" + result);

        System.out.println("Memory location of coach\n" + coach);

        // System.out.println("Memory location of alphaCoach\n" + alphaCoach);

        // close the context
        context.close();
    }
}
