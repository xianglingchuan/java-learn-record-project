package com.learn.basicSyntax;

public class DemoInnerClass {

	
	public class Inner{
		
		public void show(){
			System.out.println("inner.show method");
		}
	}
	
	
	public static void main(String[] args) {
		DemoInnerClass demoInnerClass = new DemoInnerClass();
		Inner inner = demoInnerClass.new Inner();
		inner.show();
		
		
	}
}
