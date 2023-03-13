package com.code.springannotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.code.springannotations.service.FortuneService;

@Component
// @Component("theTennisCoach")
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {
    // value injection from properties file
    @Value("${foo.time}")
    private int time;

    // field injection
    @Autowired

    // Identify service class incase muliple service implementation are there for single interface
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @PostConstruct
    public void callInitMethod() {
        System.out.println("Tennis coach bean has been initated");
    }
    
    @PreDestroy
    public void callDestoryMethod() {
        System.out.println("Tennis coach bean has been destoryed");
    }

    // constract injection

    // @Autowired
    // public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

    @Override
    public String getDailyWorkout() {
       return "Practice tennis shots for " + this.time + "minutes";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }

    // setter injection

    // @Autowired
    // @Qualifier("randomFortuneService")
    // public void setFortuneService(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

    // method injection

    // @Autowired
    // @Qualifier("randomFortuneService")
    // public void settingFortuneService(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }

    @Override
    public void destroy() throws Exception {
        System.out.println("Tennis coach bean has been destoryed");
    }
}
