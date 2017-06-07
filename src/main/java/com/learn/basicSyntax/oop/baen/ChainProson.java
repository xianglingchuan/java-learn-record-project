package com.learn.basicSyntax.oop.baen;

public class ChainProson extends Person {

	@Override
	public void say() {
		System.out.println("I Speak Chinese Words, "+getHair()+" hair, "+getDerma()+" skin.");	
	}
	
	public ChainProson(String newHair, String newDeram){
	     super(newHair,newDeram);
	}
	
	public ChainProson(){
		
	}

}
