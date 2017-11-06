package com.mode.analogjdkproxy.proxy;

import java.lang.reflect.Method;

public interface InvocationHandler {
	
	public Object invoke(Object proxy, Method method);
}
