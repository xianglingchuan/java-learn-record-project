package com.mode.strategy.impl;

import com.mode.strategy.FlyingStragety;

public class FlyNoWay implements FlyingStragety {

	@Override
	public void performFly() {
	    System.out.println("我不能飞行.");
	}

}
