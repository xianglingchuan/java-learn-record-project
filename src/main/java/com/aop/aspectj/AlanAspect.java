package com.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sun.media.jfxmedia.control.VideoDataBuffer;

@Component
@Aspect
public class AlanAspect {

	  
	@Pointcut("execution(* com.aop.aspectj.biz.*Biz.*(..))")
	public void pointcut(){
		
	}
	
	@Pointcut("within(com.aop.aspectj.biz.*)")
	public void bizPointcut(){
		
	}
	
	//@Before("execution(* com.aop.aspectj.biz.*Biz.*(..))")
	@Before("pointcut()")
	public void before(){
		System.out.println("AlanAspect...before");
	}
	
	@Before("pointcut() && args(arg)")
	public void beforeWithParam(String arg){
		System.out.println("AlanAspect...beforeWithParam arg:"+arg);
	}

	@Before("pointcut() && @annotation(alanMethod)")
	public void beforeWithAnnotation(AlanMethod alanMethod){
		System.out.println("AlanAspect...beforeWithAnnotation alanMethod:"+alanMethod.value());
	}
	
	
	@AfterReturning(pointcut="bizPointcut()",returning="returnValue")
	public void afterReturning(Object returnValue){
		System.out.println("AlanAspect...afterReturning returnValue:"+returnValue);
	}
	
	
	@AfterThrowing(pointcut="bizPointcut()",throwing="e")
	public void afterThrowing(RuntimeException e){
		System.out.println("AlanAspect...afterThrowing e:"+e.getMessage());
	}
	
	
	@After("bizPointcut()")
	public void after(){
		System.out.println("AlanAspect...after");
	}
	
	@Around("bizPointcut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("AlanAspect...around 1");
		Object retVal = pjp.proceed();
		System.out.println("AlanAspect...around 2");
		return retVal;
	}
	
	
	
}
