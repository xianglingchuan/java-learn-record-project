package com.aop.api;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class AlanMethodInterceptor implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("AlanMethodInterceptor...invoke 1:"+invocation.getMethod().getName()+
				""+invocation.getStaticPart().getClass().getName());
		Object object = invocation.proceed();
		System.out.println("AlanMethodInterceptor...invoke 2:"+object);
		return object;
	}

}
