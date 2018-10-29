package com.snowwave.concurrency.aopdemo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by zhangfuqiang on 2018/10/19.
 */
@Component
@Aspect
public class AspectImpl {

    @Pointcut("@annotation(com.snowwave.concurrency.aopdemo.Mu)")
    private void cut() {
        System.out.println("3");
    }

    @Around("cut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("1");
        try {
            joinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("4");
    }

    @Before("cut()")
    public void before() {
        System.out.println("2");
    }

    @After("cut()")
    public void after() {
        System.out.println("5");
    }

}
