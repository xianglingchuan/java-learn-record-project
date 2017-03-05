package com.learn.basicSyntax.polymorphic.telphone;

public class ShapeInitial {

	public static void main(String[] args) {
		
		Shape shape = new Circle(2.1f);
		shape.perimeter();
		shape.acreage();
		
		Shape shape2 = new Rectangle(3, 5);
		shape2.perimeter();
		shape2.acreage();
		
		
		
		
		
		
	}
}
