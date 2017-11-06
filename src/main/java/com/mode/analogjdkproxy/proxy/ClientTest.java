package com.mode.analogjdkproxy.proxy;

import java.io.IOException;

public class ClientTest {
	
	public static void main(String[] args) {
		
		//DTrain car = new DTrain();
		//DTrainTimeProxy carTimeProxy = new DTrainTimeProxy(car);
		//carTimeProxy.move();
		//System.out.println(carTimeProxy.getClass().getName());
		
		//模拟JDK动态代理类测试
		try {
			DTrainMoveable moveable =  (DTrainMoveable) Proxy.newProxyInstance(DTrainMoveable.class);
			moveable.move();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
