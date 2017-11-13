package com.mode.strategy;

public class DuckTest {
	
	public static void main(String[] args) {
		
		Duck duck = new BigYellow();
		duck.display();
		duck.fly();
		duck.eat();
		System.out.println("=====================");
		
		duck = new MallardDuck();
		duck.display();
		duck.fly();
		duck.eat();
		System.out.println("=====================");
		
		duck = new RedHeadDuck();
		duck.display();
		duck.fly();
		duck.eat();
		System.out.println("=====================");
		
		duck = new RubberDuck();
		duck.display();
		duck.fly();
		duck.eat();
		System.out.println("=====================");
		
		duck = new SpaceDuck();
		duck.display();
		duck.fly();
		duck.eat();
		System.out.println("=====================");
		
		duck = new WildDuck();
		duck.display();
		duck.fly();
		duck.eat();
		System.out.println("=====================");
	}
}
