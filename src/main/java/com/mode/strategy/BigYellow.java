package com.mode.strategy;

import com.mode.strategy.impl.EatNoWay;
import com.mode.strategy.impl.FlyNoWay;

public class BigYellow extends Duck {

	public BigYellow() {
		super();
		setFlyingStragety(new FlyNoWay());
		setEatStragety(new EatNoWay());
	}

	@Override
	public void display() {
		System.out.println("我身体很大,全身发黄");
	}

}
