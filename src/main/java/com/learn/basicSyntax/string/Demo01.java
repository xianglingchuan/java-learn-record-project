package com.learn.basicSyntax.string;

public class Demo01 {

	public static void main(String[] args) {
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		String s4 = new String("java");
		//多次出现的字符串常量，java编译程序只创建一个，所以返回true
		System.out.println(s1==s2); 
		//s1与s3是不同的对象，所对返回false
		System.out.println(s1==s3);
		//s3与s4是不同的对象，所以返回fale
		System.out.println(s3==s4);
		s1 = "欢迎来到:"+s1;
        System.out.println(s1);
		

	}

}
