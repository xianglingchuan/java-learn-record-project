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
		return "载重："+this.carWeight+"吨";
	}

	@Override
	public void setCarCustomer(int customer) {
		this.carCustomer = customer;
	}

	@Override
	public float getCarCustomer() {
		return this.carCustomer;
	}

	@Override
	public String showCarCustomer() {
		return "载客："+this.carCustomer+"人";
	}
	
    public String show(){
    	return showCarCustomer()+" "+showCarWeight();
    }

}
