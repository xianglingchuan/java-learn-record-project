package com.learn.basicSyntax.leaseCarDemo.bean;

public class FrirghtCar extends Car implements ICarWeight {

	private float carWeight = 0.0f; //载货重量
		
	public FrirghtCar(){
		
	}
	
	public FrirghtCar(String title, float rental, float weight) {
		super(title, rental);
		this.carWeight = weight;
	}
	
	
	
	@Override
	public void setCarWeight(float weight) {
		this.carWeight = weight;

	}

	@Override
	public float getCarWeight() {
		return this.carWeight;
	}

	@Override
	public String showCarWeight() {
		return "载重："+carWeight+"吨";
	}
	
    public String show(){
    	return showCarWeight();
    }	

}
