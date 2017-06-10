package com.learn.basicSyntax;

public class DemoStatic {

	
    String name; // 声明变量name
	String sex; // 声明变量sex
	static int age;// 声明静态变量age
    
    // 构造方法
	public DemoStatic () { 
		System.out.println("通过构造方法初始化name");
		name = "tom";
	}
	
	//始始化块
	{
		System.out.println("通过初始化块初始化sex值");
		sex="女";
	}
    
	
	//静态初始化块
	static {
		System.out.println("通过静态初始化块初始化age");
		age = 22;
	}

    
	public void show() {
		System.out.println("姓名：" + name + "，性别：" + sex + "，年龄：" + age);
	}
	
    
	public static void main(String[] args) {
        // 创建对象
		DemoStatic hello = new DemoStatic();
		// 调用对象的show方法
		hello.show();   
	}
	
	
	
}
