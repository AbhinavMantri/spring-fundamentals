package com.code.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
// import org.aspectj.lang.annotation.AfterReturning;

@Component
@Aspect
// aspect will run in following order
@Order(1)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());
    // @Pointcut("execution(* com.code.aop.dao.AccountDAO.*())")
    @Pointcut("execution(* com.code.aop.dao.AccountDAO.*()) || execution(* com.code.aop.dao.MemberShipDAO.*())")
    private void pointcutDemo() {
        myLogger.info("\n======>>> Executing @Before advice thorugh pointcut =======>>>");
    }
    // @Before("execution(public void addAcount())")
    // @Before("execution(public void com.code.aop.dao.AccountDAO.*())")
    // @Before("execution(public void add*())")
    // @Before("execution(* add*())")
    // @Before("execution(* com.code.aop.dao.AccountDAO.add*())")
    // @Before("execution(public * add*())")
    // @Before("execution(void add*())")
    // @Before("execution(* com.code.aop.dao.AccountDAO.*())")
    @Before("pointcutDemo()")
    public void beforeAddAccountAdvice() {
        myLogger.info("\n======>>> Executing @Before advice on addAccount =======>>>");
        // throw new Error("Error occured");
    }

    
    

    @AfterReturning("execution(* com.code.aop.dao.AccountDAO.addAcount())")
    public void AfterAddAccountAdvice() {
        myLogger.info("\n======>>> Executing @AfterReturning advice on addAccount =======>>>");
    }

    // @AfterReturning(
    // pointcut="com.code.aop.AccountDAO.addAcount()",
    // returning="retVal")
    // public void AfterReturningAcountAdvice(Object retVal) {
    //     // ...
    // }

    // @AfterThrowing(
    // pointcut="com.code.aop.AccountDAO.addAcount()",
    // returning="retVal")
    // public void AfterThrowingAcountAdvice(Object retVal) {
    //     // ...
    // }

    // @After("com.code.aop.AccountDAO.addAcount()")
    // public void After() {
    //     // ...
    // }

    @Around("execution(public void *.AccountDAO.updateAccount(..))")
    public Object AroundAddAccount(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        myLogger.info("Add account have taken " + ((end - begin)/1000.0) + " seconds");

        return result;
    }
}
