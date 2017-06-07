package com.learn.basicSyntax.polymorphic;

/*
 * 交流工具基类 
 * */
public class Vehicle {

	private int properSum = 0; //运送的人数
		
	
	public int getProperSum() {
		return properSum;
	}

	public void setProperSum(int properSum) {
		this.properSum = properSum;
	}

	
	/*
	 * 运输的方式
	 * */
	public void runMethod(){
		System.out.println("默认运输方式，可以运送旅客"+properSum+"人");
	}

	
	
	
}
