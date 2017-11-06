package com.mode.analogjdkproxy.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

	private Object target;

	public LogHandler(Object target) {
		this.target = target;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method) {

		long startTime = System.currentTimeMillis();
		System.out.println("----开始日志......" + startTime);
		try {
			method.invoke(target);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("----结束日志......运行时间" + (endTime - startTime) + "毫秒");
		return null;

	}

}
