package com.example.book.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TimeAspect {
    @Around("execution(* com.example.book.controller.*.*(..))")
    public Object timeRecord(ProceedingJoinPoint pjp) throws Throwable {
        //记录方法执行开始时间
        long start=System.currentTimeMillis();
        //执行原始方法
        Object proceed = pjp.proceed();
        //记录方法执行结束时间
        long end=System.currentTimeMillis();
        //记录方法执行耗时
        log.info(pjp.getSignature().toString()+"接口耗时："+(end-start)+"ms");
        return proceed;
    }
}
