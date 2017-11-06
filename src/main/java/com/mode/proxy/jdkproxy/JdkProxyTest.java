package com.mode.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.mode.proxy.bean.Car;
import com.mode.proxy.bean.Moveable;

public class JdkProxyTest {
	
	
	public static void main(String[] args) {
		
		Car car = new Car();
		
		InvocationHandler h = new TimeHandler(car);
		Class<?>  loader =   car.getClass();
		/**
		 * loader 类加载器
		 * interfaces 实现接口
		 * h InvocationHandler
		 * 
		 */
		Moveable moveable = (Moveable) Proxy.newProxyInstance(loader.getClassLoader(), loader.getInterfaces(), h);
		//moveable.move();
		
		//多个代理对象
		Class<?>  loader2 =   moveable.getClass();
		InvocationHandler h2 = new LogHandler(moveable);
		Moveable moveable2 = (Moveable)Proxy.newProxyInstance(loader2.getClassLoader(), loader2.getInterfaces(), h2);
		moveable2.move();
		
		
		
		
	}

}
