package com.learn.reflect;

public class Dog {

	public void print(){
	    System.out.println("汪汪汪");	
	}
	
	public void print(int age, String name){
		System.out.println("年龄:"+age+", 名称:"+name);
	}
	
	public void print(String eatName, String liveName){
		System.out.println("吃的是:"+eatName+", 住的是:"+liveName);
	}
	
	public int count(int i, int j){
		return i+j;
	}
}
