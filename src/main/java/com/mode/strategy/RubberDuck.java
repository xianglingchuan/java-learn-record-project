package com.mode.strategy;

import com.mode.strategy.impl.EatNoWay;
import com.mode.strategy.impl.FlyWithRocket;

//大黄鸭
public class RubberDuck extends Duck{

	
	
	public RubberDuck() {
		super();
		setFlyingStragety(new FlyWithRocket());
		setEatStragety(new EatNoWay());
	}

	@Override
	public void display() {
		System.out.println("我全身发黄,嘴巴很红");
	}

}
