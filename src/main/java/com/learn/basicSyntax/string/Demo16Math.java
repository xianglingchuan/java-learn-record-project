package com.learn.basicSyntax.string;

public class Demo16Math {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 12.81;
		int b = (int)a;
		
		System.out.println(a+"四舍五入后："+Math.round(a));
		System.out.println("10/3取小值："+Math.floor(a));
		System.out.println("10/3取大值："+Math.ceil(a));
		
	    double x = Math.random();
	    System.out.println("随机数:"+x);
	    
	    int y = (int)(Math.random()*9999);
	    System.out.println("随机数:"+y);

	}

}
