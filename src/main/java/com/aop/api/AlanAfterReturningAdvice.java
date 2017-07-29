package com.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AlanAfterReturningAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
	    System.out.println("AlanAfterReturningAdvice...afterReturning method:"+method.getName()+" target:"+target.getClass().getName()+""
	    		+ "   returnValue:"+returnValue);
	}

}
