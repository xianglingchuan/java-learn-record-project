package com.learn.basicSyntax.string;

public class Demo11 {

	public static void main(String[] args) {
		
		float number = 1.3f; //基它类型转换为字符串
		String str1 = Float.toString(number);
		String str2 = String.valueOf(number);
		String str3 = number + "";
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		String age  = "23"; //字符串转换为float类型 
		
	    float age1 = Float.parseFloat(age);
	    Float age2 = Float.valueOf(age);
	    System.out.println(age1);
	    System.out.println(age2);
	    
	    

	    
        		
		

	}

}
