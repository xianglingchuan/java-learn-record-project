package com.learn.basicSyntax.polymorphic;

public class VehicleInitial {

	public static void main(String[] args) {
//		Vehicle obj1 = new Vehicle();
//		Vehicle obj2 = new Bus();
//		Vehicle obj3 = new Ship();
//		Vehicle obj4 = new Airplane();
//		obj1.setProperSum(10);
//		obj1.runMethod();
//		
//		obj2.setProperSum(42);
//		obj2.runMethod();
//		
//		obj3.setProperSum(356);
//		obj3.runMethod();
//		
//		obj4.setProperSum(186);
//		obj4.runMethod();
		
		Dog dog = new Dog();
		Animal animal = dog; //向上类型转换 自动类型转换
		//Dog dog2 = (Dog)animal; //向下类型转换，存在风险
		if(animal instanceof Dog){
			System.out.println("类型转换成功，animal to Dog");
			Dog dog2 = (Dog)animal;
		}else{
			System.out.println("无法进行类型转换，animal to Dog");
		}
		
		
		//Cat cat = (Cat)animal; //编译时 cat 类型， 2、运行时Dog类型
		if(animal instanceof Cat){
			Cat cat = (Cat)animal;
			System.out.println("类型转换成功");
		}else{
			System.out.println("无法进行类型转换，因为cat不是animal的子类");
		}
		
		
		
	}
}
