package com.learn.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.learn.basicSyntax.polymorphic.initial;

public class MethodDemo01 {

	public static void main(String[] args) {
		//要获取print(int, string)方法
		//1 要获取一个方法就是获取类的的信息，获取类的信息首先要获取类的类类类型 
		Dog a1 = new Dog();
		Class class1 = a1.getClass();
		
		/*
		 * 2 获取方法名称和参数列表来决定
		 * getMethod获取的是public的方法
		 * getDelcaredMethod自己声明的方法
		 * 
		 */
		try {
			//Method method = class1.getMethod("print", new Class[] {int.class, String.class});
			Method method = class1.getMethod("print", int.class, String.class);
			//方法的反射操作
			a1.print(10, "wanwan");
			//方法的反射操作是用emthod对象来进行方法调用和a1.print调用的效果完全相同
			//方法如果没有返回值返回null,有返回值返回具体的返回值
			method.invoke(a1, new Object[] {22,"wanwan"});
			//method.invoke(a1, 23,"wanwan.");
			System.out.println("=========================================");
			
			Method method2 = class1.getMethod("print", new Class[]{String.class,String.class});
			method2.invoke(a1, new Object[]{"骨头","狗窝"});
			
			System.out.println("=========================================");
			Method method3 = class1.getMethod("print");
			method3.invoke(a1);
			
			System.out.println("=========================================");
			Method method4 = class1.getMethod("count", int.class, int.class);
			int count = (Integer)method4.invoke(a1, 2, 5);
			System.out.println("计算相加的值为:"+count);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}




