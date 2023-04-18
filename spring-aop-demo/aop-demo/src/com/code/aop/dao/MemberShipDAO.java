package com.code.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {
    public void addAccount() {
        System.out.println("Adding a memebership account");
    }
}
