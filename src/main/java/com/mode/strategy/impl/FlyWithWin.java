package com.mode.strategy.impl;

import com.mode.strategy.FlyingStragety;

public class FlyWithWin implements FlyingStragety {

	@Override
	public void performFly() {
		System.out.println("振翅高飞");
	}

}
