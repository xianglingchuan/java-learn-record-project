package com.aop.schema.advice.biz;

public class AspectBiz {

	
	public void say(){
		System.out.println("AspectBiz say...");
		//throw new RuntimeException();
	}
	
	
	public void init(String name, int age){
		
		System.out.println("AspectBiz arounInit... name:"+name+" and age:"+age);
	}
	

}
