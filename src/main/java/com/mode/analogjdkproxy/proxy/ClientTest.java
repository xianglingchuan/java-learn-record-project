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
			//第一版，代理类写在Proxy内
			//DTrainMoveable moveable =  (DTrainMoveable) Proxy.newProxyInstance(DTrainMoveable.class);
			//moveable.move();
			
			
			//第二版，代理类由外部传入
			DTrain car = new DTrain();
			LogHandler h = new LogHandler(car);
			DTrainMoveable moveable =  (DTrainMoveable) ProxyTwo.newProxyInstance(DTrainMoveable.class,h);
			moveable.move();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
