package com.lidl.shopping.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderLoggingAspect {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(OrderLoggingAspect.class);
    
    @Pointcut("execution(public * com.lidl.shopping.service.controllers.OrderController.*(..))")
    public void logOrderCreation() {}
    
    @Before(value = "logOrderCreation()")
    public void beforeMethodCallAdvice(JoinPoint jp) {
        LOGGER.info(jp.getSignature().toString());
    }
    
    @Around(value = "logOrderCreation()")
    public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        
        LOGGER.info("in around advice");
        // some code prior to method call
        Object result = jp.proceed();
        // code after method call
        return result;
    }
    
}
