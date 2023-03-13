package com.code.springannotations.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// bean scope
@Scope("singleton")
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is the happiest day";
    }
    
}
