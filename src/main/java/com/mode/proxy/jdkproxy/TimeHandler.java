package com.mode.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	private Object target;

	public TimeHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		long startTime = System.currentTimeMillis();
		System.out.println("记录开始时间......"+startTime);		
		
		method.invoke(target);
		
		System.out.println("记录结束时间......");
		long endTime = System.currentTimeMillis();
		System.out.println("汽车运行时间是:" + (endTime - startTime) + "毫秒");		
		
		return null;
	}

}
