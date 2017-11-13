package com.mode.strategy;

import com.mode.strategy.impl.EatNoWay;
import com.mode.strategy.impl.FlyWithWin;

//红头鸭
public class RedHeadDuck extends Duck {

	public RedHeadDuck() {
		super();
		setFlyingStragety(new FlyWithWin());
		setEatStragety(new EatNoWay());
	}

	@Override
	public void display() {
		System.out.println("我的头是红色的.");
	}

}
