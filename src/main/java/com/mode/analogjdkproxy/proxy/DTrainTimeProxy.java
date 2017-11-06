package com.mode.analogjdkproxy.proxy;

public class DTrainTimeProxy implements DTrainMoveable {

	private DTrainMoveable moveable;

	public DTrainTimeProxy(DTrainMoveable moveable) {
		this.moveable = moveable;
	}

	@Override
	public void move() {
		long startTime = System.currentTimeMillis();
		System.out.println("--记录开始时间......"+startTime);
		moveable.move();
		long endTime = System.currentTimeMillis();
		System.out.println("--记录结束时间......运行时间为:"+ (endTime - startTime) + "毫秒");
	}
}
