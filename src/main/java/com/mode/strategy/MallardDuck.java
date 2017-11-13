package com.mode.strategy;

import com.mode.strategy.impl.EatNoWay;
import com.mode.strategy.impl.FlyNoWay;
import com.mode.strategy.impl.FlyWithWin;

//脖子是绿色的鸭子
public class MallardDuck extends Duck{

	
	
	public MallardDuck() {
		super();
		setFlyingStragety(new FlyWithWin());
		setEatStragety(new EatNoWay());
	}

	@Override
	public void display() {
		System.out.println("我的脖子是绿色的");
	}

}
