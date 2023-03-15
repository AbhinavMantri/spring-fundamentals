package com.code.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.code.aop.dao.AccountDAO;
import com.code.aop.dao.MemberShipDAO;

public class MainApp {
    public static void main(String[] args) {
        // read spring config class
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(DemoConfig.class);
        
        // reading the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        MemberShipDAO memberDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

        // call the business method
        accountDAO.addAcount();

        memberDAO.addAccount();

        accountDAO.addAmountCredit(30.00);

        accountDAO.addAmountDebit(5.00);

        accountDAO.getBalance();


        accountDAO.updateAccount();

        // close the context
        context.close();
    }
}
