package com.mode.strategy;

import com.mode.strategy.impl.EatNoWay;
import com.mode.strategy.impl.FlyWithRocket;
import com.mode.strategy.impl.FlyWithWin;

//太空鸭
public class SpaceDuck extends Duck {

	public SpaceDuck() {
		super();
		setFlyingStragety(new FlyWithRocket());
		setEatStragety(new EatNoWay());
	}

	@Override
	public void display() {
		System.out.println("我头戴宇航头盔");
	}

}
