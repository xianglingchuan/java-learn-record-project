package com.mode.strategy;

import com.mode.strategy.impl.EatNoWay;
import com.mode.strategy.impl.EatWithRice;
import com.mode.strategy.impl.FlyWithWin;

//野鸭子
public class WildDuck extends Duck {

	public WildDuck() {
		super();
		setFlyingStragety(new FlyWithWin());
		setEatStragety(new EatWithRice());
	}

	@Override
	public void display() {
		System.out.println("我是小野鸭,全身色彩斑斑.");
	}

}
