package com.learn.basicSyntax.string;

import org.apache.catalina.tribes.util.Arrays;

public class Demo02 {

	public static void main(String[] args) {
		String str = "好好学习 Java 编程";
	    System.out.println("字符串长度："+str.length());
	    System.out.println("字符'编'的位置："+str.indexOf("编"));
	    System.out.println("字符串'Java'的位置："+str.indexOf("Java"));
	    System.out.println("字符串'好好'的位置："+str.indexOf("好好"));
	    String[] arr = str.split(" ");
	    System.out.println("按空格拆分成数组："+Arrays.toString(arr));
	    System.out.println("获取位置[9,11]："+str.substring(10, 12));
	}

}
