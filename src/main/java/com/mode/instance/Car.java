package com.mode.instance;

//单例模式 - 饿汉模式
public class Car {	
	
	private static Car car = new Car();
	
	public static Car getInstance(){
		return car;
	}

}
