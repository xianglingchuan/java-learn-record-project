package com.learn.basicSyntax.polymorphic;

public class initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal obj1 = new Animal();
		Animal obj2 = new Dog();
		//Dog obj3 = new Animal(); //子类对象不对指向父类对象
	    obj1.eat();
	    obj2.eat();
	    Animal obj3 = new Cat();
	    obj3.eat();
	}

}
