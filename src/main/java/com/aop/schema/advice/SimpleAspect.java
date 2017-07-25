package com.aop.schema.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class SimpleAspect {

	
	public void before(){
		System.out.println("SimpleAspect before...");
	}
	
	public void afterReturning(){
		System.out.println("SimpleAspect afterReturning...");
	}	
	
	public void afterThrowing(){
		System.out.println("SimpleAspect afterThrowing...");
	}
	
	public void after(){
		System.out.println("SimpleAspect after...");
	}
	
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		 System.out.println("SimpleAspect around...start");
		 Object retVal = pjp.proceed();
		 System.out.println("SimpleAspect around...end");		 
		 return retVal;
	}
	
	
	public Object aroundInit(ProceedingJoinPoint pjp,String name, int age) throws Throwable{
		 System.out.println("SimpleAspect aroundInit name:"+name+" and age:"+age);
		 System.out.println("SimpleAspect aroundInit...start");
		 Object retVal = pjp.proceed();
		 System.out.println("SimpleAspect aroundInit...end");		 
		 return retVal;
	}	
	
}
