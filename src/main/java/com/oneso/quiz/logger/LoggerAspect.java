package com.oneso.quiz.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * Личный логгер
 */
@Aspect
@Component
public class LoggerAspect {

    @Around("@within(com.oneso.quiz.logger.MyLogger)")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.printf("[Info]: %s - %s%n", joinPoint.getClass().getName(), joinPoint.getSignature().getName());

        Object method = joinPoint.proceed();

        System.out.println("[Return]: " + method);

        return joinPoint.proceed();
    }
}
