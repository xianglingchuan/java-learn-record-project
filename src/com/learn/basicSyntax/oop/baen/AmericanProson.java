package com.learn.basicSyntax.oop.baen;

public class AmericanProson extends Person {

	@Override
	public void say() {
		System.out.println("I Speak English Words, "+getHair()+" hair, "+getDerma()+" skin.");
	}

	
	public AmericanProson(String newHair, String newDeram){
	     super(newHair,newDeram);
	}
	
	public AmericanProson(){
		
	}
	
	
}
