package com.learn.basicSyntax.leaseCarDemo.bean;

public class PickupCar extends Car implements ICarCustomer, ICarWeight {

	private float carWeight;
	private int carCustomer;
	
	
	public PickupCar(){
		
	}
	
	public PickupCar(String title, float rental, int customer, float weight) {
		super(title, rental);
		this.carWeight = weight;
		this.carCustomer = customer;
	}
	
	
	public void setCarWeight(float weight) {
		this.carWeight = weight;
	}

	public float getCarWeight() {
		return this.carWeight;
	}

	public String showCarWeight() {
		return "载重："+this.carWeight+"吨";
	}

	public void setCarCustomer(int customer) {
		this.carCustomer = customer;
	}

	public float getCarCustomer() {
		return this.carCustomer;
	}

	public String showCarCustomer() {
		return "载客："+this.carCustomer+"人";
	}
	
    public String show(){
    	return showCarCustomer()+" "+showCarWeight();
    }

}
