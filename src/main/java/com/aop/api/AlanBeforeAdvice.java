package com.aop.api;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AlanBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		System.out.println("BeforeAdvice:"+method.getName()+" : "+target.getClass().getName());

	}

}
