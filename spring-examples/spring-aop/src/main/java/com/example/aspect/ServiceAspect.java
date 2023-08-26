package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {


    //@Pointcut("execution(* com.example.controller.*.*(..))")
    @Pointcut("within(com.example.service.*)")
    //@Pointcut("this(com.example.service.MessageService)")
    //@Pointcut("@annotation(com.example.annotation.CustomAnnotation)")
    public void loggingPointCut(){}

/*
    @Before("loggingPointCut()")
    public void before( JoinPoint joinPoint ){
        System.out.println("Before method invoked::"+joinPoint.getSignature());
    }

 */

    /*
    @AfterReturning(value = "execution(* com.example.controller.*.*(..))", returning = "stringResponseEntity")
    public void after( JoinPoint joinPoint, ResponseEntity<String> stringResponseEntity ){
        System.out.println("AfterReturning method invoked::"+stringResponseEntity.getBody());
    }
     */

    /*
    @AfterThrowing(value = "execution(* com.example.controller.*.*(..))",
            throwing = "e")
    public void after( JoinPoint joinPoint, Exception e ){
        System.out.println("AfterThrowing method invoked::"+e.getMessage());
    }

     */


    @Around("loggingPointCut()")
    public String around( ProceedingJoinPoint joinPoint ) throws Throwable {
        String message;
        System.out.println("Around Before method invoked: " + joinPoint.getSignature().getName());
        try {
            message = (String) joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        System.out.println("Around After method invoked: " + joinPoint.getSignature().getName());

        return message;
    }
    
/*
    @Before("execution(* com.example.service.MessageService.sendMessage(..))")
    public void sendMessageBeforeMethod(JoinPoint joinPoint) {
        System.out.println("sendMessage Before Method param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.example.service.*.*(..))")
    public void sendMessageAfterMethod(JoinPoint joinPoint) {
        System.out.println("sendMessage After Method param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

 */
}

