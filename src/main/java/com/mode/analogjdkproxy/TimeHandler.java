package com.mode.analogjdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler {

	private Object target;

	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		long startTime = System.currentTimeMillis();
		System.out.println("----记录开始时间......" + startTime);
		method.invoke(target);
		long endTime = System.currentTimeMillis();
		System.out.println("----记录结束时间......运行时间" + (endTime - startTime) + "毫秒");
		return null;

	}

}
