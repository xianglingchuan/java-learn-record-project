package com.mode.strategy.impl;

import com.mode.strategy.EatStragety;

public class EatNoWay implements EatStragety {

	@Override
	public void performEat() {
		System.out.println("我不用吃东西.");
	}

}
