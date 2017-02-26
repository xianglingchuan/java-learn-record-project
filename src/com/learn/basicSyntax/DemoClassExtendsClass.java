package com.learn.basicSyntax;

import com.learn.basicSyntax.bean.Animal;
import com.learn.basicSyntax.bean.Dog;

public class DemoClassExtendsClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Dog dog = new Dog(18);
//		dog.age = 1;
//		dog.name = "wowo";
//		dog.eat();
//		
//		System.out.println(dog);
		
		//Animal animal = new Animal();
		//System.out.println("age:"+animal.age);
		//dog.method();
		
		Dog dog = new Dog();
		Dog dog2 = new Dog();
		if(dog.equals(dog2)){
			System.out.println("两个值对象是想同的");
		}else{
			System.out.println("两个值对象是不相同的");
		}
		
		
		
	}
}
