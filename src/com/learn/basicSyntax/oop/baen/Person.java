package com.learn.basicSyntax.oop.baen;


public abstract class Person {

	private String hair;  //头像
	private String derma; //皮肤
	
	
	public String getHair() {
		return hair;
	}


	public void setHair(String hair) {
		this.hair = hair;
	}


	public String getDerma() {
		return derma;
	}


	public void setDerma(String derma) {
		this.derma = derma;
	}


	public Person(){
		
	}
	
	public Person(String newHair, String newDerma){
		this.hair = newHair;
		this.derma = newDerma;
	}

	
	
	public abstract void say(); //说明
	
	
}
