package com.learn.basicSyntax.bean;

public class Dog extends Animal {

	public int age;
	
	public void eat(){
		System.out.println("年龄:"+age+"岁, 狗不能吃草.");
	}
	
	public Dog(){
		super(10);
		System.out.println("执行Dog类的构造方法.");
		age = 58;
	}
	
	public void method(){
		System.out.println("执行method.");
		System.out.println("parent.age:"+super.age);
		super.eat();
	}
	
	
	public Dog(int age){
		super(age);
		System.out.println("执行Dog类的构造方法.");
		age = 58;
	}

	@Override
	public String toString() {
		return "Dog [age=" + age + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		//getClass主要关注代码的结构块，例如方法、属性
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		return true;
	}
	
}
