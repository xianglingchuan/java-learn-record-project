package com.learn.basicSyntax.bean;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Animal {

	public int age = 10;
	
	public String name;
	
	final int weight;
	
	public void eat(){
		System.out.println("动物可以吃东西.");
	}	
	
//	public Animal(){
//		System.out.println("执行Animal类构造方法.");
//		age = 100;
//		weight = 100; //必须初始化体重值
//	}
	
	public Animal(int age){
		System.out.println("执行Animal类构造方法.");
		age = 100;
		weight = 100; //必须初始化体重值
	}

	
	
}
