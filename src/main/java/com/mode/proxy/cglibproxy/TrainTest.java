package com.mode.proxy.cglibproxy;

public class TrainTest {

	public static void main(String[] args) {

		CglibProxy proxy = new CglibProxy();
		Train train = (Train) proxy.getProxy(Train.class);
		train.move();

	}

}
