package com.learn.basicSyntax.leaseCarDemo.bean;

public class CustomerCar extends Car implements ICarCustomer {

	private int carCustomer;
	
	public CustomerCar(){
		
	}
	
	public CustomerCar(String title, float rental, int customer) {
		super(title, rental);
		this.carCustomer = customer;
	}
	
	
	
	public void setCarCustomer(int customer) {
	     this.carCustomer = customer;
	}


	public float getCarCustomer() {
		return this.carCustomer;
	}

	public String showCarCustomer() {
		return "载客:"+this.carCustomer+"人";
	}

    public String show(){
    	return showCarCustomer();
    }
    
	
}
