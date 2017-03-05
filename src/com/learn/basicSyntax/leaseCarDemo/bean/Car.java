package com.learn.basicSyntax.leaseCarDemo.bean;

public class Car {

	private String title; //车的名称

	private float rental; //车的租金
	
	
	public Car(){
		
	}
	
	public Car(String title, float rental) {
		this.title = title;
		this.rental = rental;
	}

	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getRental() {
		return rental;
	}

	public void setRental(float rental) {
		this.rental = rental;
	}
	
    public String show(){
    	return "";
    }	
}
