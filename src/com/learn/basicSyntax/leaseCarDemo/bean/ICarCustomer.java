package com.learn.basicSyntax.leaseCarDemo.bean;

public interface ICarCustomer {

	//设置载客人数
	public abstract void setCarCustomer(int customer);
	
	//获取载客人数
	public abstract float getCarCustomer();
	
	//显示载客人数
	public abstract String showCarCustomer();
	
	
	
}
