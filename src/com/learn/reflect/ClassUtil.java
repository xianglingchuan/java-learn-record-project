package com.learn.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ClassUtil {

	
	/*
	 * 打印类的信息，包括类的成员函数、成员变量(只获取成员函数)
	 * @param obj   该对象所属类的信息
	 * 
	 * */
	public static void printClassMethodMessage(Object obj){
		//要获取类的信息，首先要获取类的类类型
		Class class1 =  obj.getClass();//传递的是那个子类的对象，class1就是那个类的类类型 
		
		//第一步获取类的名称
		System.out.println("类的名子："+class1.getName());
		
		//获取类的所有方法
		/*Method类，方法对象
		 * 一个成员方法就是一个Method对象
		 * getMethods()方法获取的所有的public的函数，包括父类继承而来的
		 * getDeclaredMethods()获取的是所有该类自己声明的方法，不管访问权限
		 * 
		 * 
		 * */
		Method[] Methods = class1.getMethods();
		for (Method method : Methods) {
			//获取方法返回值的类类型
		   Class returnTypeClass = method.getReturnType();
		   System.out.print(returnTypeClass.getName()+" ");
		   //获取方法的名称
		   System.out.print(method.getName()+" (");
		   
		   //开始获取传入的参数类型信息
		   Parameter[] parameters =  method.getParameters();
		   for (Parameter parameter : parameters) {
		        //System.out.print(parameter.getType()+" "+parameter.getName()+",");
		   }	
		   
		   Class[] paramTypes = method.getParameterTypes();
		   for (Class class2 : paramTypes) {
			   System.out.print(class2.getName()+",");
		   }
		   
		   System.out.print(")");
		   System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		Integer obj = new Integer(1);
		ClassUtil.printClassMethodMessage(obj);
	}
	
	
}
