package com.code.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    private double balance;
    public void addAcount() {
        System.out.println(getClass() + ": Doing my work for adding an account");
    }

    public void addAmountCredit(double amount) {
        balance += amount;
        System.out.println("Adding new credited amount for this account: " + amount);
    }

    public void addAmountDebit(double amount) {
        balance -= amount;
        System.out.println("Adding new debited amount for this account: " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void updateAccount() {
        System.out.println("updating the account");
    }
}
