package com.mode.strategy;

/**
 * 
 * 超类，所有的鸭子都经继承此类
 * 抽象了鸭子的行为： 显示和鸣叫
 * 
 * */
public abstract class Duck {

     public void quack(){
    	 System.out.println("嘎嘎嘎");
     }
     
     //显示鸭子的外观
     public abstract void display();
     
     
     //鸭子飞行的策略类
     private FlyingStragety flyingStragety;


	public void setFlyingStragety(FlyingStragety flyingStragety) {
		this.flyingStragety = flyingStragety;
	}
     
	//鸭子的吃的策略类
	private EatStragety  eatStragety;
	
	public void setEatStragety(EatStragety eatStragety) {
		this.eatStragety = eatStragety;
	}

	//鸭子实现飞行
	public void fly(){
		this.flyingStragety.performFly();
	}
	
	//鸭子实现吃东西
	public void eat(){
		this.eatStragety.performEat();
	}	
}
