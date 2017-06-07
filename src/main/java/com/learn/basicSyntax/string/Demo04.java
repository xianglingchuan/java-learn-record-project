package com.learn.basicSyntax.string;

public class Demo04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "好好学习 Java 编程";
		
		System.out.println("转换成小字结果为:"+str.toLowerCase());
		System.out.println("转换成大字结果为:"+str.toUpperCase());
		
		byte[] bytes = str.getBytes();
		for(int i=0; i<bytes.length; i++){
			System.out.print(bytes[i]+",");
		}
		System.out.println("");
		
		String str2 = new String("好好学习 Java 编程");
		System.out.println("两个字符串内存地址是否相同:"+(str==str2));
		System.out.println("两个字符串内容是否相同:"+(str.equals(str2)));
		
		
		

	}

}
