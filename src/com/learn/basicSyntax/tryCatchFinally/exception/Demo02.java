package com.learn.basicSyntax.tryCatchFinally.exception;

public class Demo02 {

	public static void main(String[] args) {
		
		//两个值的交换
		String A = "A";
		String B = "B";
		System.out.println("值交换前: A="+A+", B:"+B);
		String C = A;
		A = B;
		B = C;
		System.out.println("值交换前: A="+A+", B:"+B);
		
		
		//获取积的方式
		System.out.println("===========第二种交换=============");
		int a = 22;
		int b = 33;
		System.out.println("值交换前: a="+a+", b:"+b);
		a = a + b; //55
		b = a - b; //22
		a = a - b; //33
		System.out.println("值交换前: a="+a+", b:"+b);
		
		
		//使用位移的方江苏
		System.out.println("===========第三种交换=============");
		int aa = 22;
		int bb = 33;
		System.out.println("值交换前: aa="+aa+", bb:"+bb);
		aa = aa ^ bb; 
		bb = aa ^ bb; 
		aa = aa ^ bb; 
		System.out.println("值交换前: aa="+aa+", bb:"+bb);
		
		
		//位数取反值
		System.out.println("===========位数取反值=============");
		int c = 1;
		System.out.println(~0);
		
		
		//左移运算<<
		System.out.println("===========左移运算<<=============");
		System.out.println(2 << 1);
		System.out.println(11 << 2);
		
		
	
	}

}












