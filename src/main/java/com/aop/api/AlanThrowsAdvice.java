package com.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;


public class AlanThrowsAdvice implements ThrowsAdvice {

	
	public void afterThrowing(Exception exception) throws Throwable{
		 System.out.println("AlanThrowsAdvice afterThrowing...1");
	}
	
	public void afterThrowing(Method method,Object[] args, Object target, Exception exception){
		System.out.println("AlanThrowsAdvice afterThrowing...2 method:"+method.getName()+"  target:"+target.getClass().getName());
	}
	
}
