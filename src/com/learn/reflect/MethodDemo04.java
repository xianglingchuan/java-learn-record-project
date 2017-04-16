package com.learn.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo04 {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		ArrayList<String> list2 =  new ArrayList<String>();
		list2.add("hello");
		//list2.add(11); //错误指定了类型 
		Class class1 = list.getClass();
		Class class2 = list2.getClass();
		System.out.println(class1==class2);
		
		//反射的操作都是编译之后的操作
		
		/*
		 * class1==class2结果返回true说明编译之后集合的泛型是去泛型化的
		 * Java中集合的泛型，是防止错误输入的，只在编译阶段有效，绕过编译就无效了
		 * 验证：我们可以通过方法的反射来操作，绕过编译
		 * 
		 * */
		try {
			Method method =  class2.getMethod("add", Object.class);
			method.invoke(list2, 1000); //绕过编译操作就绕过了泛型
			System.out.println(list2.size());
			System.out.println(list2);
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}










