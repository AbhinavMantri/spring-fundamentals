package com.code.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class PerformanceLoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {
        myLogger.info("\n======>>> Executing @Before advice on addAccount to performance =======>>>");
    }

    @Before("execution(public void addAmount*(*))")
    public void beforeAddAmountAdvice(JoinPoint joinPoint) {
        myLogger.info("" + joinPoint.getSignature());
        myLogger.info("\n======>>> Executing @Before advice on addAmount to performance =======>>>");

        System.out.print("method arguments: ");
        for(Object arg: joinPoint.getArgs()) {
            System.out.print(arg + ", ");
        }
        myLogger.info("");
    }

    @AfterReturning(pointcut = "execution(public double getBalance())", returning = "result")
    public void beforeAddAmountAdvice(double result) {
        myLogger.info("\n======>>> Executing @AfterReturning advice on getBalance to performance =======>>>");
        myLogger.info("<========Balance========>" + result);
    }
}
