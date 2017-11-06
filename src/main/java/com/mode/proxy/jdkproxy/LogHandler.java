package com.mode.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	private Object target;

	public LogHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("日志记录开始......");	
		method.invoke(target);
		System.out.println("日志记录结束......");	
		
		return null;
	}

}
