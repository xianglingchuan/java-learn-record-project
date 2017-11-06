package com.mode.proxy.bean;


public class CarTwo extends Car {

	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("汽车开始行始......");
		super.move();
		System.out.println("汽车结束行始......");
		long endTime = System.currentTimeMillis();
		System.out.println("汽车运行时间是:" + (endTime - startTime) + "毫秒");
	}

}
