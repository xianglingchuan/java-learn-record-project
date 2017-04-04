package com.learn.basicSyntax.string;

public class Demo10 {

	public static void main(String[] args) {
		//基本类型 与 包装类型 之间的自动装箱和自动拆箱
		
		int number = 10;
		Integer number1 = new Integer(number); //手动装箱
		Integer number2 = number;  //自动装箱
	    System.out.println(number1);
	    System.out.println(number2);
	    
	    Integer age = new Integer(23);
	    int age1 = age.intValue();  //手动拆箱
	    int age2 = age;  //自动拆箱
	    System.out.println(age1);
	    System.out.println(age2);
	    age.doubleValue();
	    
	    
		

	}

}
