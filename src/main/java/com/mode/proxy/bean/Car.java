package com.mode.proxy.bean;

import java.util.Random;

public class Car implements Moveable {

	@Override
	public void move() {
		 try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("汽车运行中......");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
