package com.learn.basicSyntax.polymorphic.telphone;

public class Circle extends Shape {

	private float pi = 3.14f;
	
	private float radius = 0.0f;
	
	
	public Circle(float newRadius){
		radius = newRadius;
	}
	
	@Override
	public void perimeter() {
		float perimeterNumber = pi*(radius*2);
		System.out.println("圆的周长perimeterNumber:"+perimeterNumber);
	}

	@Override
	public void acreage() {
	  float	acreageNumber =  this.pi*(radius*radius);
	  System.out.println("圆的面职acreageNumber:"+acreageNumber);
	}

}
