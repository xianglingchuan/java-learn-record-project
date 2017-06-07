package com.learn.basicSyntax.string;

public class Demo07StringBuilder {

	public static void main(String[] args) {
		StringBuilder stringBuilder =  new StringBuilder("I love");
		stringBuilder.append(" Java");
		stringBuilder.append(" 编程");
		System.out.println(stringBuilder.toString());
		System.out.println("字符串长度:"+stringBuilder.length());
		System.out.println("插入之前："+stringBuilder);
		
		stringBuilder.insert(stringBuilder.indexOf(" Java"), " very good");
		System.out.println("插入之后："+stringBuilder);

	}

}
