package com.learn.reflect;

import java.awt.Window.Type;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
	
	/*
	 * 获取所有类的成员变量信息
	 * @param obj   该对象所属类的信息
	 * 
	 * 成员变量也是对象
	 * java.lang.reflect.Filed
	 * Field类封装了关于成员变量的操作
	 * getFields()方法获取的是所有的public的成员变量的信息
	 * getDeclaredFields获取的是该类自己声明的成员变量的信息
	 * 
	 * */
    public static void printClassAttribute(Object obj){
    	//获取该类的类类型 
    	Class class1 =  obj.getClass();
    	
    	//Field[] fs =  class1.getFields();
    	Field[] fields = class1.getDeclaredFields();
    	for (Field field : fields) {
    		//field.getType()
    		//获取类函数的类类型 
    		Class fieldTypeClass = field.getType();
    		java.lang.reflect.Type genericType = field.getGenericType();
    		System.out.println(fieldTypeClass.getName()+" "+field.getName());
		}
    }
	
    
    
	/*
     * 构造函数也是对象
     * java.lang.Constructor中封装了构造函数的信息
     * getConstructors获取所有的public的构造函数
     * getDeclaredConstructors得到所有的构造函数
	 * 
	 * */	
    public static void printClassConMessage(Object obj){
    	Class class1 =  obj.getClass();
    	Constructor[] cons = class1.getConstructors();
    	for (Constructor constructor : cons) {
    		System.out.print(constructor.getName()+" (");
    		
    		Class[] parameters = constructor.getParameterTypes();
    		for (Class class2 : parameters) {
				//获取
    			Class parametersClass = class2.getClass();
    			String parameterTypeName =  parametersClass.getName();
    			String parameterName = class2.getName();
    			System.out.print(parameterTypeName+" "+parameterName+", ");
			}
    		System.out.println(constructor.getName()+" )");
    		
    	}
    	
    	
    }
    
    
	
	public static void main(String[] args) {
		Integer obj = new Integer(1);
		//ClassUtil.printClassMethodMessage(obj);
		//ClassUtil.printClassAttribute(obj);
		String string  = new String("xxd");
		ClassUtil.printClassConMessage(string);
	}
	
	
}









