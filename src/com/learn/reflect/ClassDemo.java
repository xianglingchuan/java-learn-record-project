package com.learn.reflect;

public class ClassDemo {

	public static void main(String[] args) {
		//Foo的实例对象如何表
		Foo foo1 = new Foo(); //foo1就表示出来了
		//Foo这个类也是一个实例对象，Class类的实例对象如何表示呢
		//任何一个类都是Class的实例对象，这个实例对象有三种表示方式
		
		//第一种表达方式---->实际在告诉我们任何 个类都有一个隐含的静态成员方法
		Class class1 = Foo.class;
		
		//第二种表达方式 已经知道该类的对象通过getClass方法
		Class class2 = foo1.getClass();
		
		/* 官网c1,c2表示了Foo类的类类型(class type)
		 * 万事万物皆对象
		 * 类也是对象，是Class类的实例对象
		 * 这个对象我们称为该类的类类型
		 * 
		 * */
		
		//不管class1 or class2都代表了Foo类的类类型，一个类只可能是Class类的一个实例对象
		System.out.println(class1 == class2); //等于
		
		//第三种表达方式
		Class class3 = null;
		try {
			class3 = Class.forName("com.learn.reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(class2 == class3);
		
		//我们完全可以通过类的类类型创建该类的对象实例-->通过class1 or class2 or class3 创建Foo的实例
		
		//前提需要有无参的构造方法
		try {
			//进行强制类型转换，前提条件是必须有无参的构造方法
			Foo foo2 = (Foo)class1.newInstance();
			foo2.printFoo();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		try {
			Foo foo3 = (Foo)class2.newInstance();
			foo3.printFoo();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
