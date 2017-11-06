package com.mode.analogjdkproxy.proxy;
public class $Proxy0 implements DTrainMoveable {
	private DTrainMoveable moveable;
	public $Proxy0(DTrainMoveable moveable) {
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