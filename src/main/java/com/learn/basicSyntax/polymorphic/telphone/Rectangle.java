package com.learn.basicSyntax.polymorphic.telphone;

public class Rectangle extends Shape {

	private float width = 0.0f;
	
	private float height = 0.0f;
	
	
	public Rectangle(float newWidth, float newHeight){
		this.width = newWidth;
		this.height = newHeight;
	}
	
	@Override
	public void perimeter() {
		
		float perimeterNumber = (this.width + this.height)*2;
		System.out.println("圆的周长:"+perimeterNumber);
		
	}

	@Override
	public void acreage() {
		float acreageNumber = this.width * this.height;
		System.out.println("圆的面职:"+acreageNumber);
	}

}
