package com.mode.strategy.impl;

import com.mode.strategy.FlyingStragety;

public class FlyWithRocket implements FlyingStragety {

	@Override
	public void performFly() {
		System.out.println("用火箭在太空遨游");
	}

}
