package com.mode.proxy.bean;

public class CarLogProxy implements Moveable {

	private Moveable moveable;

	public CarLogProxy(Moveable moveable) {
		this.moveable = moveable;
	}	
	
	
	@Override
	public void move() {
		
		System.out.println("开始记录日志......");
		
		moveable.move();
		
		System.out.println("结束记录日志......");

		
		
	}

}
