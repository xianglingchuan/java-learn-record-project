package com.mode.proxy;

import com.mode.proxy.bean.Car;
import com.mode.proxy.bean.CarLogProxy;
import com.mode.proxy.bean.CarThree;
import com.mode.proxy.bean.CarTimeProxy;
import com.mode.proxy.bean.CarTwo;
import com.mode.proxy.bean.Moveable;

public class CarTest {

	public static void main(String[] args) {

		// Moveable car = new Car();
		// car.move();

		// 使用集成方式
		// Moveable car2 = new CarTwo();
		// car2.move();

		// 使用聚合方式实现
		// Car car = new Car();
		// CarThree carThree = new CarThree(car);
		// carThree.move();

		//建立统一的日志和时间代理类
		Moveable car = new Car();
		CarLogProxy carLogProxy = new CarLogProxy(car);
		CarTimeProxy carTimeProxy = new CarTimeProxy(carLogProxy);
		carTimeProxy.move();
		
		
		

	}

}
