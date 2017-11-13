package com.mode.strategy.impl;

import com.mode.strategy.EatStragety;

public class EatWithRice implements EatStragety {

	@Override
	public void performEat() {
		System.out.println("我喜欢吃大米.");
	}

}
