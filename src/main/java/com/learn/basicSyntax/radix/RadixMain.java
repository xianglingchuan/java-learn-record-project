package com.learn.basicSyntax.radix;

public class RadixMain {

	public static void main(String[] args) {
		//十进制转为其它进制
		System.out.println("===========十进制转换为二进制==============");
		System.out.println(Integer.toBinaryString(122));
		
		System.out.println("===========十进制转换为十六进制==============");
		System.out.println(Integer.toHexString(112));
		
		System.out.println("===========十进制转换为八进制==============");
		System.out.println(Integer.toOctalString(122));
		
		
		//其他进制转化为十进制
		System.out.println("===========二进制转换为十进制==============");
		System.out.println(Integer.parseInt("111001",2));
		
		System.out.println("===========二进制转换为八进制==============");
		System.out.println(Integer.parseInt("37",8));
		
		System.out.println("===========二进制转换为十六进制==============");
		System.out.println(Integer.parseInt("A8",16));
		
		
		

	}

}
