package com.mode.analogjdkproxy.proxy;

import java.util.Random;

public class DTrain implements DTrainMoveable {

	@Override
	public void move() {
		 try {
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("复兴号动车--运行中......");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
