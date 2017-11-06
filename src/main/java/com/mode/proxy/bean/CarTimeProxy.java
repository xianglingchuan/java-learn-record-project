package com.mode.proxy.bean;

public class CarTimeProxy implements Moveable {

	private Moveable moveable;

	public CarTimeProxy(Moveable moveable) {
		this.moveable = moveable;
	}

	@Override
	public void move() {
		
		long startTime = System.currentTimeMillis();
		System.out.println("记录开始时间......"+startTime);
		
		moveable.move();
		
		System.out.println("记录结束时间......");
		long endTime = System.currentTimeMillis();
		System.out.println("汽车运行时间是:" + (endTime - startTime) + "毫秒");

	}

}
