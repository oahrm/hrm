package com.hrm.oa.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {
    //注解配置切入点
    @Pointcut(value = "execution(* com.hrm.oa.service..*.*(..))")
    public void logpointCut(){

    }

    @Before(value = "logpointCut()")
    public void beforeAdivice(JoinPoint joinPoint){
        log.debug("》》》》》》》》》》》》》》》》》》》》》》》》》》》》》》进入{}类的{}方法，",joinPoint.getTarget().getClass(),
                joinPoint.getSignature());
    }
    @After(value = "logpointCut()")
    public void afterAdivice(JoinPoint joinPoint){
        log.debug("《《《《《《《《《《《《《《《《《《《《《《《《《《《《《《完成{}类的{}方法，",joinPoint.getTarget().getClass(),
                joinPoint.getSignature());

    }
}
