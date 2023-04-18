package com.mycode.springboot.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
// primary class to pick in case there is no qualifier at dependency injection
@Primary
// only initialize when it is needed
@Lazy
// bean scope
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BaseballCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Played a baseball match at Mumbai";
    }
    
}
