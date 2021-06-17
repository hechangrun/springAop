package com.hcr.aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.hcr.service.impl.*.add(..))")
    public void propertyAccess(){ }

//
//    @Before(value = "execution(public * com.hcr.service.impl.*.add(..))")
//    public void before(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        System.out.println(methodName + "方法运行，参数是：" + Arrays.asList(args));
//        System.out.println("前置通知");
//    }
//
//    @After("propertyAccess()")
//    public void after(){
//        System.out.println("后置通知");
//    }
//
//    @AfterReturning(value = "execution(public * com.hcr.service.impl.*.add(..))" , returning="returnValue")
//    public void afterRetruning(Object returnValue){
//        System.out.println("返回值：" + returnValue);
//    }

//    @AfterThrowing(value = "execution(public * com.hcr.service.impl.*.add(..))",throwing="val")
//    public void afterThrowing(){
//
//    }
    
    @Around("propertyAccess()")
    public void around(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Object returnValue = "";

        System.out.println(methodName + "方法运行，参数是：" + Arrays.asList(args));
        try{
            System.out.println("前置通知");
            returnValue = joinPoint.proceed();
            System.out.println("后置通知");
        }catch (Throwable throwable){
            System.out.println("异常通知" + throwable);
        }finally {
            System.out.println("返回通知" + returnValue);
        }
    }     
    
}
